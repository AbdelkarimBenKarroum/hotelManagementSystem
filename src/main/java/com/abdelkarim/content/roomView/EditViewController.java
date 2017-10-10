/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.content.roomView;

import com.abdelkarim.db.impl.RoomCategoryDAOImp;
import com.abdelkarim.db.impl.RoomDAOImp;
import com.abdelkarim.db.model_objects.Room;
import com.abdelkarim.db.model_objects.RoomCategory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author abdelkarim
 */
public class EditViewController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextField idInput;
    @FXML
    private JFXTextField price;
    @FXML
    private JFXComboBox<String> categoryOptions;
    @FXML
    private JFXComboBox<String> availabilityOptions;
    @FXML
    private JFXComboBox<Integer> floorOptions;
    @FXML
    private JFXButton registerBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private Label closeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getCategories();
        availabilityOptions.getItems().addAll("Yes","No");
        floorOptions.getItems().addAll(1,2,3,4,5);
    }    

    @FXML
    private void register(ActionEvent event) {
        Room room=null;
        //take variables first then assign them to the room object
        //id
        String id=idInput.getText();
        //room.setId(id);
        //price variable
        Double Price=Double.parseDouble(price.getText());
        //room.setPrice(Price);
        //Room category object
        String type=categoryOptions.getValue();
        RoomCategory cate=RoomCategoryDAOImp.getInstance().getCategoryIdByName(type);
        //room.setCategory(cate);
        //floor variable assignement
        Byte floor=Byte.parseByte(floorOptions.getValue().toString());
        //room.setFloor(floor);
        //availability 
        boolean avail;
        if (availabilityOptions.getValue().equalsIgnoreCase("yes")) {
            avail=true;
        }
        else avail=false;
        //room.setIsAvailable(avail);
        
        room=new Room(id, Price, cate, floor, type, avail);
        //adding using RoomDAOImp singlton object
        RoomDAOImp.getInstance().updateRoom(room);
        idInput.clear();
        price.clear();
    }
    public void getCategories(){
    ObservableList<String> categoryOpts=FXCollections.observableArrayList();
     List<RoomCategory> list=RoomCategoryDAOImp.getInstance().getAllRoomCategories();
        for (RoomCategory roomCategory : list) {
            categoryOpts.add(roomCategory.getCategory_name());
        }
       categoryOptions.getItems().addAll(categoryOpts);
    }
    
    @FXML
    private void cancel(ActionEvent event) {
     rootPane.getScene().getWindow().hide();
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        rootPane.getScene().getWindow().hide();
    }
    public void setFields(Room ro){
        String id=ro.getId();
        Double Price=ro.getPrice();
        idInput.setText(id);
        price.setText(Price.toString());
        
    
    }
}
