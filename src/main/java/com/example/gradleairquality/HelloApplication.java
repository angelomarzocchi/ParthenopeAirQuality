package com.example.gradleairquality;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


public class HelloApplication extends Application {

    public static void main(String[] args) {


        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            String css = this.getClass().getResource("style.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }

    }



}