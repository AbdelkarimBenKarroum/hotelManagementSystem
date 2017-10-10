package com.abdelkarim.content.roomView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.abdelkarim.content.guestView.GuestViewController;
import com.abdelkarim.db.impl.RoomDAOImp;
import com.abdelkarim.db.model_objects.Room;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author abdelkarim
 */
public class RoomViewController implements Initializable {

    @FXML
    private TableView<Room> roomTable;
    @FXML
    private TableColumn<Room,String> id;
    @FXML
    private TableColumn<Room, Double> price;
    @FXML
    private TableColumn<Room, String> category;
    @FXML
    private TableColumn<Room, Byte> floor;
    @FXML
    private Label regularBtn;
    @FXML
    private Label doubleBedBtn;
    @FXML
    private Label kingSizedRoomBtn;
    @FXML
    private TableColumn<Room, Boolean> avail;
    @FXML
    private Label newRoom;
    @FXML
    private Label editBtn;
    @FXML
    private Label removeBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        getListOfRooms();
    }   
    public void initCol(){
        id.setCellValueFactory(new PropertyValueFactory("id"));
        price.setCellValueFactory(new PropertyValueFactory("price"));
        category.setCellValueFactory(new PropertyValueFactory("category_name"));
        floor.setCellValueFactory(new PropertyValueFactory("floor"));
        avail.setCellValueFactory(new PropertyValueFactory("isAvailable"));
        
    }
    public void getListOfRooms(){
        ObservableList<Room> list=FXCollections.observableArrayList();
        List<Room>rooms= RoomDAOImp.getInstance().getAllRooms();
        for (Room room : rooms) {
            list.add(room);
        }
        roomTable.getItems().addAll(list);
    }
    public void getListOfRooms( String type){
        roomTable.getItems().clear();
        ObservableList<Room> list=FXCollections.observableArrayList();
        List<Room>rooms= RoomDAOImp.getInstance().getSpecifiedRooms(type);
        for (Room room : rooms) {
            list.add(room);
        }
        roomTable.getItems().addAll(list);
    }
    @FXML
    private void getRegularRooms(MouseEvent event) {
        getListOfRooms("regular");
    }

    @FXML
    private void getDoubleBedRooms(MouseEvent event) {
        getListOfRooms("double_bed");
    }

    @FXML
    private void getKingSizedRooms(MouseEvent event) {
        getListOfRooms("king_size");
    }

    @FXML
    private void addNewRoom(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddRoom.fxml"));
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
    private void editRoom(MouseEvent event) {
        Room room=roomTable.getSelectionModel().getSelectedItem();
        if (room==null) {
            FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.WARNING);
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Select an item to be updated");
            alert.setGraphic(icon);
            alert.showAndWait();
        }
        else{
            
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/EditView.fxml"));
            Parent root=loader.load();
            EditViewController editing=loader.getController();
            editing.setFields(room);
            Stage stage=new Stage();
            Scene scene=new Scene(root);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            
            stage.setTitle("Editing Rooms infos");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }

    @FXML
    private void removeRoom(MouseEvent event) {
       Room room=roomTable.getSelectionModel().getSelectedItem();
        if (room==null) {
            FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.WARNING);
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Select an item to be updated");
            alert.setGraphic(icon);
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Are you sure you want to delete room with id="+room.getId());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                RoomDAOImp.getInstance().removeRoom(room.getId());
            } else {
                alert.close();
            }
        }
    }
    
}
