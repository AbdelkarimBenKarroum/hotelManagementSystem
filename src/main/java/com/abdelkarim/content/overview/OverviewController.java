/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.content.overview;

import com.abdelkarim.db.impl.RoomDAOImp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdelkarim
 */
public class OverviewController implements Initializable {

    @FXML
    private VBox overviewPane;
    @FXML
    private Label totalRooms;
    @FXML
    private Label OccupiedRooms;
    @FXML
    private Label availableRooms;
    @FXML
    private Label regularRooms;
    @FXML
    private Label doubleBedRooms;
    @FXML
    private Label kingSizedRooms;
    @FXML
    private Label guestTotal;
    @FXML
    private Label guestMen;
    @FXML
    private Label guestsWomen;
    @FXML
    private Label CheckingToday;
    @FXML
    private Label unspecifiedChecking;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalRooms.setText(RoomDAOImp.getInstance().totalRooms()+"");
        availableRooms.setText(RoomDAOImp.getInstance().availableRooms()+"");
        OccupiedRooms.setText(RoomDAOImp.getInstance().occupiedRooms()+"");
        regularRooms.setText(RoomDAOImp.getInstance().totalRoomsByType(1)+"");
        doubleBedRooms.setText(RoomDAOImp.getInstance().totalRoomsByType(2)+"");
        kingSizedRooms.setText(RoomDAOImp.getInstance().totalRoomsByType(3)+"");
    }    

    @FXML
    private void viewAllRooms(MouseEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/RoomView.fxml"));
            Parent root=loader.load();
            Stage stage=new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.setTitle("All rooms");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(OverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void viewAllGuests(MouseEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/GuestView.fxml"));
            Parent root=loader.load();
            Stage stage=new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.setTitle("All Guests");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
