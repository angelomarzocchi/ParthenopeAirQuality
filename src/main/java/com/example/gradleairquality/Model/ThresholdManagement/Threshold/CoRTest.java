package com.example.gradleairquality.Model.ThresholdManagement.Threshold;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.*;
import com.example.gradleairquality.Model.UserManagement.Manager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.management.Query;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Map;


public class CoRTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Manager manager = new Manager("MRZNGL98S25F839T","pagliaccio");
        manager.logIn();
        ThresholdsCareTaker caretaker = new ThresholdsCareTaker(manager);


        Sensor sensor1 = new Sensor("Melito","abc",11.21,11.52);
        Sensor sensor2 = new Sensor("Melito","abc",11.21,11.52);
        Sensor sensor3 = new Sensor("Melito","abc",11.21,11.52);

        HumidityDecorator humSensor1 = new HumidityDecorator(sensor1);
        HumidityDecorator humSensor2 = new HumidityDecorator(sensor2);
        TemperatureDecorator tempSensor1 = new TemperatureDecorator(sensor3);

        HumidityThresholdEditor humEditor = new HumidityThresholdEditor(null);
        TemperatureThresholdEditor tempEditor = new TemperatureThresholdEditor(humEditor);
        ThresholdsMap map = ThresholdsMap.getThresholdsInstance(manager);
        Map<measureType,Threshold> thresholds = map.getThresholds();
        ThresholdExceedingChecker check = new ThresholdExceedingChecker();
        thresholds.get(measureType.HUMIDITY).addSubscriber(check);
        thresholds.get(measureType.TEMPERATURE).addSubscriber(check);
        sensor1.addSubscriber(check);
        sensor2.addSubscriber(check);
        sensor3.addSubscriber(check);

       /* System.out.println(ThresholdsMap.getThresholdsInstance().
                getThresholds()
                .get(measureType.HUMIDITY)
                .getType());

        System.out.println(ThresholdsMap.getThresholdsInstance().
                getThresholds()
                .get(measureType.HUMIDITY)
                .getThreshold());*/

        humSensor1.addMeasure(new Measure(measureType.HUMIDITY, LocalDate.now(),90));
        humSensor2.addMeasure(new Measure(measureType.HUMIDITY,LocalDate.now(),45));
        humSensor2.addMeasure(new Measure(measureType.TEMPERATURE,LocalDate.now(),30));


        tempEditor.edit(new EditRequest(80,measureType.HUMIDITY),manager);
        caretaker.saveSnapshot();
        tempEditor.edit(new EditRequest(95,measureType.HUMIDITY),manager);
        System.out.println(ThresholdsMap.getThresholdsInstance(manager));
        caretaker.undo();
        System.out.println(ThresholdsMap.getThresholdsInstance(manager));
        sensor2.setOnlineStatus(false);
        humSensor2.addMeasure(new Measure(measureType.HUMIDITY,LocalDate.now(),99));
        tempSensor1.addMeasure(new Measure(measureType.TEMPERATURE,LocalDate.now(),31));
        map.saveChanges(manager);

       /* System.out.println(ThresholdsMap.getThresholdsInstance().
                getThresholds()
                .get(measureType.HUMIDITY)
                .getType());

        System.out.println(ThresholdsMap.getThresholdsInstance().
                getThresholds()
                .get(measureType.HUMIDITY)
                .getThreshold());*/
        //ThresholdsMap.getThresholdsInstance().resetToDefaultValues();
       // System.out.println(ThresholdsMap.getThresholdsInstance());



//Codice per backupare il json
/*
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(map);
        try {
            FileWriter writer = new FileWriter("src/FileSystem/thresholds.json");
            writer.write(json);
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }

 */


        


    }
}
