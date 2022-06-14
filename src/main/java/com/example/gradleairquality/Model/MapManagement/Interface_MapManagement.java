package com.example.gradleairquality.Model.MapManagement;
/* RENAME STRATEGY */
//Creiamo un'interfaccia comune alle classi per utilizzare il design
//pattern Strategy
import com.example.gradleairquality.Model.UserManagement.Manager;
import com.example.gradleairquality.Model.UserManagement.Manager;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

public interface Interface_MapManagement{

    LinkedList<BufferedImage> viewmap(Manager manager);
    void viewSensorPoints();

}
