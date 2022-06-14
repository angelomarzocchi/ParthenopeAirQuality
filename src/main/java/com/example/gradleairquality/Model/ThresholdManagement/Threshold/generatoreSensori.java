package com.example.gradleairquality.Model.ThresholdManagement.Threshold;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.Sensor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class generatoreSensori {
    public static void main(String[] args) {
        //generare una lista di sensori e scriverla in formato json tramite Gson

        LinkedList<Sensor> lista = new LinkedList<>();

        int code = 10000;
        for(int i=0;i < 1000; i++){
            code += i;
            int random = new Random().nextInt(Comuni.values().length);
            lista.add(new Sensor(Comuni.values()[random].getNome(),
                    Integer.toString(code),
                    Comuni.values()[random].getLatitudine(),Comuni.values()[random].getLongitudine()));
        }



        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(lista);
        try {
            FileWriter writer = new FileWriter("src/FileSystem/sensors.json");
            writer.write(json);
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }






    }
}
