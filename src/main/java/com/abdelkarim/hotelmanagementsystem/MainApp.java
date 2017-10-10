package com.abdelkarim.hotelmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginScreen.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/splash.css");
        stage.initStyle(StageStyle.UNDECORATED);
        //instance of Context make it global
        Context context=Context.getInstance();
        //stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
