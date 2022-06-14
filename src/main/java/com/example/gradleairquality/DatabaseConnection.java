package com.example.gradleairquality;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseUsername = "root";
        String databasePassword = "parthenope";
        String url = "jdbc:mysql://localhost:3306/dashboard";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUsername,databasePassword);
        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }


}
