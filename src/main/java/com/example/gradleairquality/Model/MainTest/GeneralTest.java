package com.example.gradleairquality.Model.MainTest;
import com.example.gradleairquality.Model.CompareManagement.SensorComparator;
import com.example.gradleairquality.Model.MapManagement.GeographicMap;
import com.example.gradleairquality.Model.MapManagement.Planimetry;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.Sensor;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.measureType;
import com.example.gradleairquality.Model.ThresholdManagement.Threshold.Comuni;
import com.example.gradleairquality.Model.ThresholdManagement.Threshold.ThresholdsMap;
import com.example.gradleairquality.Model.ThresholdManagement.fakeAPI;
import com.example.gradleairquality.Model.UserManagement.Manager;
import com.example.gradleairquality.Model.UserManagement.User;
import com.google.gson.reflect.TypeToken;

import javax.management.Query;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class GeneralTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //log-in
        Manager manager = new Manager("DRSGNR97L07F839U","password");
        manager.logIn();


        System.out.println(manager.getUsername());
        Planimetry map = new Planimetry(manager.getGovernanceArea().getNome(),15.1,15.1,15.1);
        BufferedImage mapImage = map.viewmap(manager).getFirst();
        System.out.println("Dimensioni:" +mapImage.getHeight() +"x"+ mapImage.getWidth());











        //visualizzazione sensori associati al manager che ha fatto log-in
       String sensors = fakeAPI.getSensors(manager,new TypeToken<LinkedList<Sensor>>() {}.getType());
        System.out.println(sensors);

        //visualizzare soglie
        ThresholdsMap thresholds =ThresholdsMap.getThresholdsInstance(manager);
        System.out.println(thresholds.getThresholds().get(measureType.HUMIDITY).getType() + " " +
                        thresholds.getThresholds().get(measureType.HUMIDITY).getThreshold()
                );



        //modificare soglie

        //TODO implementare modifica delle soglie su db invece che su filesystem
        //verificare password retreivement
        //comparare 2 sensori


        //

    }
}
