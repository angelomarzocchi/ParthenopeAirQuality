package com.example.gradleairquality.Model.ThresholdManagement;

import com.example.gradleairquality.Model.UserManagement.DBService;
import com.example.gradleairquality.Model.UserManagement.Manager;

import java.sql.*;

public class dbTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

Manager manager = new Manager("MRZNGL98S25F839T","pagliaccio");
manager.logIn();
           ResultSet rs = DBService.getSensors(manager);
                rs.beforeFirst();
            while(rs.next()){
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getBoolean(3) + " " +
                        rs.getString(4) + " " +
                        rs.getDouble(5) + " " +
                        rs.getDouble(6)

                );
            }



    }
}
