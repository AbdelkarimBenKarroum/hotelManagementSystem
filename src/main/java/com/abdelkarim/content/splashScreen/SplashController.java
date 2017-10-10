
package com.abdelkarim.content.splashScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author abdelkarim
 */
public class SplashController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new SplashScreen().start();
    }   
    class SplashScreen extends Thread{
        
        @Override
        public void run(){
            try {
                Thread.sleep(5000);
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/fxml/loginScreen.fxml"));
                            Scene scene = new Scene(root);
                            //scene.getStylesheets().add("/styles/splash.css");
                            
                            Stage stage = new Stage();
                            stage.initStyle(StageStyle.UNDECORATED);
                            stage.setScene(scene);
                            stage.show();
                            
                            rootPane.getScene().getWindow().hide();
                           
                        } catch (IOException ex) {
                            Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        
        }
   
    }
    
}
