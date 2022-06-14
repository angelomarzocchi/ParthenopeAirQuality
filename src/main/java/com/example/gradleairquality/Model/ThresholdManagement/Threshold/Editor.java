package com.example.gradleairquality.Model.ThresholdManagement.Threshold;
import com.example.gradleairquality.Model.UserManagement.Manager;

public interface Editor {
    void edit(EditRequest request, Manager manager);
}
