package com.abdelkarim.content.bookings;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
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
public class BookingViewController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextField userNameInput;
    @FXML
    private JFXTextField emailInput;
    @FXML
    private JFXButton registerBtn;
    @FXML
    private JFXTextField emailInput1;
    @FXML
    private JFXTextField addressInput1;
    @FXML
    private JFXButton registerBtn1;
    @FXML
    private Label closeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void register(ActionEvent event) {
    }

    @FXML
    private void closeWindow(MouseEvent event) {
        rootPane.getScene().getWindow().hide();
    }
    
}
