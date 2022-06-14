package com.example.gradleairquality.Model.ThresholdManagement.Threshold;

import com.example.gradleairquality.Model.UserManagement.Manager;

public abstract class ThresholdEditor implements Editor {

    public ThresholdEditor(Editor nextEditor) {
        this.nextEditor = nextEditor;
    }

    public abstract void edit(EditRequest request, Manager manager);


    protected Editor getNextEditor() {
        return nextEditor;
    }

    public void setNextEditor(Editor nextEditor) {
        this.nextEditor = nextEditor;
    }

    private Editor nextEditor;


}
