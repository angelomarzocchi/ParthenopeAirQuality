package com.example.gradleairquality.Model.ThresholdManagement.Threshold;
import com.example.gradleairquality.Model.UserManagement.Manager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

public class ThresholdsCareTaker {
    private Stack<ThresholdsMap.Memento> mementos;
    private Manager loggedIn;

    public ThresholdsCareTaker(Manager manager) {
        mementos = new Stack<>();
        loggedIn = manager;

    }
    protected void undo() throws SQLException, ClassNotFoundException {
        if (mementos.size() > 0) {
            ThresholdsMap.getThresholdsInstance(loggedIn).restoreFromSnapshot(mementos.pop());
        }
    }
    protected void saveSnapshot() throws SQLException, ClassNotFoundException {
            mementos.add(ThresholdsMap.getThresholdsInstance(loggedIn).getSnapshot());
        }

}
