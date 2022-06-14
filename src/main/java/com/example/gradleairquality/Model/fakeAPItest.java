package com.example.gradleairquality.Model;

import com.example.gradleairquality.Model.ThresholdManagement.*;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.Sensor;
import com.example.gradleairquality.Model.ThresholdManagement.Threshold.Comuni;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.Sensor;
import com.example.gradleairquality.Model.UserManagement.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class fakeAPItest {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        Manager manager = new Manager("MRZNGL98S25F839T","pagliaccio");
        manager.logIn();

        String string = fakeAPI.getSensors(manager,new TypeToken<LinkedList<Sensor>>() {}.getType());
        System.out.println(string);




    }
}
