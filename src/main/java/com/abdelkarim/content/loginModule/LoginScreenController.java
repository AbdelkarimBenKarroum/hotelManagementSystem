/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.content.loginModule;

import com.abdelkarim.content.dashboard.DashboardMainController;
import com.abdelkarim.db.impl.UserDAOImp;
import com.abdelkarim.db.model_objects.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author abdelkarim
 */
public class LoginScreenController implements Initializable {

    @FXML
    private Label closeBtn;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label dragBar;
    double Xposition, Yposition;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private JFXTextField userName;
    @FXML
    private JFXPasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        rootPane.getScene().getWindow().hide();
    }

    @FXML
    private void loginFormDragged(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();

        rootPane.getScene().getWindow().setX(x - Xposition);
        rootPane.getScene().getWindow().setY(y - Yposition);

    }

    @FXML
    private void mousePressedForLocation(MouseEvent event) {
        Xposition = event.getX();
        Yposition = event.getY();
    }

    private void signUp(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/RegisterScreen.fxml"));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add("/styles/splash.css");

            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            rootPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Login(ActionEvent event) {
        
        
        String user_name = userName.getText();
        String pass = password.getText();
        User userModel = new User();
        userModel.setUser_name(user_name);
        userModel.setUser_password(pass);
        
        try {
            
            User user = UserDAOImp.getInstance().getUser(userModel);
            if (user == null) {
                FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.WARNING);
                Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Enter a valid user name");
            alert.setGraphic(icon);
            alert.showAndWait();
            } else {
                Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Successfully logged");
            alert.setHeaderText(null);
            alert.showAndWait();
               
               //create a loader for fxml view
               FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/DashboardMain.fxml"));
                       //FXMLLoader.load(getClass().getResource(""));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                //scene.getStylesheets().add("/styles/splash.css");
                DashboardMainController dashController=loader.getController();
                dashController.setUserSession(user.getUser_name(),user.getUser_role().getRole_id());
                Stage stage = new Stage();
                stage.setMaximized(true);
                stage.setScene(scene);
                stage.show();

                rootPane.getScene().getWindow().hide();
                //if (user.getUser_role().getRole_id()!=1) {
                //    DashboardMainController co=new DashboardMainController();
                 //   co.adminBtn.setDisable(true);
                //}
                
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
