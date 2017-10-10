/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.content.guestView;

import com.abdelkarim.db.impl.GuestDAOImp;
import com.abdelkarim.db.model_objects.GuestInfo;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author abdelkarim
 */
public class GuestViewController implements Initializable {

    
    @FXML
    private JFXButton listBtn;

    @FXML
    private JFXButton newGuestBtn;

    @FXML
    private JFXButton archiveBtn;
    @FXML
    private TableView<GuestInfo> table;
    @FXML
    private TableColumn<GuestInfo,String> ID;
    @FXML
    private TableColumn<GuestInfo,String> firstName;
    @FXML
    private TableColumn<GuestInfo,String> lastName;
    @FXML
    private TableColumn<GuestInfo,Object> dateOfBirth;
    @FXML
    private TableColumn<GuestInfo,String> phoneNumber;
    @FXML
    private TableColumn<GuestInfo,String> gender;
    ObservableList<GuestInfo> list=FXCollections.observableArrayList();
    
    
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ID.setCellValueFactory(new PropertyValueFactory<GuestInfo,String>("Id"));
        firstName.setCellValueFactory(new PropertyValueFactory<GuestInfo,String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<GuestInfo,String>("lastName"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<GuestInfo,Object>("DOB"));
        gender.setCellValueFactory(new PropertyValueFactory<GuestInfo,String>("gender"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<GuestInfo,String>("phoneNumber"));
        getList();
    }
    @FXML
    void addGuestAction(ActionEvent event)  {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/BookingView.fxml"));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add("/styles/splash.css");

            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(GuestViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void archivedGuests(ActionEvent event) {

    }

    @FXML
    void getListOfGuests(ActionEvent event) {
        table.getItems().clear();
        getList();
        
    }
    void getList(){
    GuestDAOImp guestManager=GuestDAOImp.getInstance();
        List<GuestInfo> guests=guestManager.getAllGuets();
        //GuestInfo gInfo;
        for(GuestInfo guest:guests){
            System.out.println(guest.toString());
            list.add(guest);
        }
        
       table.getItems().setAll(list);
    
    }
}
