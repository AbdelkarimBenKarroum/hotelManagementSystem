/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.content.dashboard;

import com.abdelkarim.db.impl.UserDAOImp;
import com.abdelkarim.db.impl.UserRoleDAOImp;
import com.abdelkarim.db.model_objects.UserRole;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.effects.JFXDepthManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author abdelkarim
 */
public class DashboardMainController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private JFXButton hotelStatusBtn;
    JFXDepthManager dManager;
    int depth;
    @FXML
    private JFXButton guestBtn;
    @FXML
    private JFXButton RoomBtn;
    @FXML
    private Label userSession;
    @FXML
    private JFXButton logout;
    @FXML
    public  JFXButton adminBtn;
    public DashboardMainController(){
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dManager=new JFXDepthManager();
        depth=1;
        VBox centerPane;
        try {
            
            centerPane =(VBox)FXMLLoader.load(getClass().getResource("/fxml/Overview.fxml"));
            dManager.setDepth(centerPane, depth);
             mainPane.setCenter(centerPane);
             
        } catch (IOException ex) {
            Logger.getLogger(DashboardMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void loadOverview(ActionEvent event) throws SQLException {
        depth=1;
        VBox centerPane;
        try {
            centerPane = (VBox) FXMLLoader.load(getClass().getResource("/fxml/Overview.fxml"));
            dManager.setDepth(centerPane, depth);
             mainPane.setCenter(centerPane);
             UserDAOImp imp=UserDAOImp.getInstance();
            UserRole userrole=new UserRole(3,"executor");
            UserRoleDAOImp roleManager=UserRoleDAOImp.getInstance();
            roleManager.addUserRole(userrole);
//        User user=new User("nezha","ben","1994",userrole);
//        user.setUser_id("b1216");
//        if (imp.addUser(user)) {
//            Alert alert=new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Adding operation");
//            alert.setContentText("Successfully added");           
//        }
//        System.out.println(imp.addUser(user));

        } catch (IOException ex) {
            Logger.getLogger(DashboardMainController.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
            }

    @FXML
    private void loadGuestView(ActionEvent event) {
        depth=1;
        VBox centerPane;
        try {
            FXMLLoader viewLoader=new FXMLLoader(getClass().getResource("/fxml/GuestView.fxml"));
            centerPane = viewLoader.load();
            dManager.setDepth(centerPane, depth);
             mainPane.setCenter(centerPane);
             
        } catch (IOException ex) {
            Logger.getLogger(DashboardMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void loadRoomView(ActionEvent event) {
        depth=1;
        HBox centerPane;
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/RoomView.fxml"));
            centerPane = loader.load();
            dManager.setDepth(centerPane, depth);
             mainPane.setCenter(centerPane);
             
             
        } catch (IOException ex) {
            Logger.getLogger(DashboardMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logoutAction(ActionEvent event) {
        try {
            
            
             Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginScreen.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/splash.css");
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        //stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
            mainPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(DashboardMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
            
    }

    @FXML
    private void showUsers(ActionEvent event) {
        
    }
    public void setUserSession(String userName,int RoleId){
        UserRole userRole=UserRoleDAOImp.getInstance().getUserRoleById(RoleId);
        if (userRole.getRole_name().equalsIgnoreCase("admin")) {
            userSession.setText("Status:Admin "+userName);
        }
        else {
            userSession.setText("Status:"+userRole.getRole_name()+" "+userName);
            adminBtn.setDisable(true);
        }
    }
}
