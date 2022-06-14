package com.example.gradleairquality.Model.ThresholdManagement;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.Measure;
import com.example.gradleairquality.Model.ThresholdManagement.Threshold.Comuni;
import com.example.gradleairquality.Model.ThresholdManagement.*;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.Measure;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.Sensor;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.measureType;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.Sensor;
import com.example.gradleairquality.Model.UserManagement.Manager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class fakeAPI {

    //metodo per restituire i sensori
    //in base al user che si passa

    public static String getSensors(Manager manager,Type clazz){
        //leggere da sensors.json e restiture solo i sensori che appartengono  a manager
        LinkedList<Sensor> list;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path path =  Paths.get("src/main/java/com/example/gradleairquality/Model/FileSystem/sensors.json");
        String returnPath = "";
        try {
            String string = Files.readString(path);
            list  = gson.fromJson(string,  clazz);
           List<Sensor> filteredList = list.stream().filter(m -> m.getLocation().equals( manager.getGovernanceArea().getNome())).toList();
           String filteredListToString = gson.toJson(filteredList);
             returnPath = "src/main/java/com/example/gradleairquality/Model/FileSystem/" + manager.getUsername().replace(" ","_") + ".json";

            FileWriter writer = new FileWriter(returnPath);
            writer.write(filteredListToString);
            writer.close();


        } catch(IOException e){
            e.printStackTrace();
        }

        return returnPath;


    }

    //metodo per restiture le misurazioni in base all'user che le richiede
   public static String getLatestMeasures(Manager manager) throws IOException {
        HashMap<String, Measure> map = new HashMap<>();
        String fromWhere = getSensors(manager,  new TypeToken<LinkedList<Sensor>>() {}.getType());
        Path path = Paths.get(fromWhere);
        String jsonToString = Files.readString(path);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        LinkedList<Sensor> sensorsList;
        sensorsList = gson.fromJson(jsonToString,new TypeToken<LinkedList<Sensor>>() {}.getType());
        for( Sensor s : sensorsList){
            int random = new Random().nextInt(measureType.values().length);
            measureType randomType = measureType.values()[random];
            int randomValue = 0;
            switch(randomType){
                case HUMIDITY -> randomValue = new Random().nextInt(60,80);
                case TEMPERATURE -> randomValue = new Random().nextInt(20,32);
                case CARBON -> randomValue = new Random().nextInt(350,1500);
                case WIND -> randomValue = new Random().nextInt(10,40);
                case PM2 -> randomValue = new Random().nextInt(25,100);
                case PM10 -> randomValue = new Random().nextInt(30,120);
            }
            Measure temp = new Measure(randomType, LocalDate.now(),randomValue);
            map.put(s.getCode(),temp);

        }
        String toJson = gson.toJson(map);
        try {
            FileWriter writer = new FileWriter("src/main/java/com/example/dashboard/Model/FileSystem/latestValues.json");
            writer.write(toJson);
            writer.close();
            return "src/main/java/com/example/dashboard/Model/FileSystem/latestValues.json";
        } catch(IOException e){
            e.printStackTrace();
        }

       return null;
   }



}
