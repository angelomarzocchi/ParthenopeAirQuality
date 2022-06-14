package com.example.gradleairquality;

import com.example.gradleairquality.Model.ThresholdManagement.Sensor.Sensor;
import com.example.gradleairquality.Model.UserManagement.DBService;
import com.example.gradleairquality.Model.UserManagement.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Manager manager;

    public void sendManager(Manager manager){
        this.manager = manager;

    }

    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void switchToCompare(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("compare.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEdit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    private ListView<String> listView;
    LinkedList<Sensor> sensors;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}



