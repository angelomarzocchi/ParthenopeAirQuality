package com.example.gradleairquality.Model.ThresholdManagement.Threshold;

import com.example.gradleairquality.Model.ThresholdManagement.Sensor.measureType;

public interface ThresholdUpdateListener {

    void update(int newValue, measureType type, Publisher p);

}
