/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.content.registerModule;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
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
public class RegisterScreenController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label closeBtn;
    @FXML
    private JFXTextField userNameInput;
    @FXML
    private JFXTextField emailInput;
    @FXML
    private JFXPasswordField passwordInput;
    @FXML
    private JFXTextField addressInput;
    @FXML
    private JFXButton registerBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeWindow(MouseEvent event) {
        rootPane.getScene().getWindow().hide();
    }

    @FXML
    private void register(ActionEvent event) {
    }
    
}
