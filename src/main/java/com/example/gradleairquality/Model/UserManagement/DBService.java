package com.example.gradleairquality.Model.UserManagement;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.measureType;
import com.example.gradleairquality.Model.ThresholdManagement.Threshold.Threshold;
import com.example.gradleairquality.Model.ThresholdManagement.Threshold.ThresholdsMap;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class DBService {

    public static ResultSet logIn(String username, String password) throws ClassNotFoundException, SQLException {
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/dashboard";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "parthenope");
        String query = "SELECT * FROM utente where CF='" + username + "'" + "and PASSWORD ='" + password + "'";

        Statement st = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return rs;
        }else return null;
    }


    public static ResultSet getSensors(Manager manager) throws SQLException, ClassNotFoundException {
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/dashboard";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "parthenope");
        String query = "SELECT * FROM SENSOR where CF='" + manager.getUsername() + "'";
        Statement st = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return rs;
        }else return null;

    }

    public static ResultSet getThresholds(Manager manager) throws ClassNotFoundException, SQLException{
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/dashboard";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "parthenope");
        String query = "SELECT * FROM threshold where cf= '" + manager.username + "'";
        Statement st = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            return rs;
        }else return null;
    }

    public static void saveThresholds(Manager manager) throws ClassNotFoundException, SQLException {
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/dashboard";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "parthenope");
        ThresholdsMap map = ThresholdsMap.getThresholdsInstance(manager);
        Map<measureType, Threshold> thresholds = map.getThresholds();

        ArrayList<PreparedStatement> queryList = new ArrayList<>();


        for(measureType measure:  measureType.values()){
            PreparedStatement temp = conn.prepareStatement("UPDATE threshold set value = ? where cf = ? AND type = ?",ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            temp.setInt(1,thresholds.get(measure).getThreshold());
            temp.setString(2, manager.username);
            temp.setString(3, measure.name());

            queryList.add(temp);

        }


        for (PreparedStatement preparedStatement : queryList) {
            //String query = preparedStatement.toString().replace("com.mysql.cj.jdbc.ClientPreparedStatement: ","");
             preparedStatement.executeUpdate();
        }

    }



}
