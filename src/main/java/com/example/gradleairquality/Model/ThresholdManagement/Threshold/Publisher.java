package com.example.gradleairquality.Model.ThresholdManagement.Threshold;

import java.util.ArrayList;

/**
 * interfaccia per implementare Observer
 */
public interface Publisher {

    void addSubscriber(ThresholdUpdateListener t);
    void removeSubscriber(ThresholdUpdateListener t);

}
