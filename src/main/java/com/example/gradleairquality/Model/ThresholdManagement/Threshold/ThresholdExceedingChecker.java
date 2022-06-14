package com.example.gradleairquality.Model.ThresholdManagement.Threshold;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.*;
import java.util.HashMap;
import java.util.Map;

public class ThresholdExceedingChecker implements ThresholdUpdateListener {


    private final Map<measureType,Integer> thresholdValueHolder = new HashMap<>();
    private final Map<measureType,Integer> sensorValueHolder = new HashMap<>();


    public void update(int newValue, measureType type,Publisher p) {
        if(p.getClass() == Sensor.class){

            if(sensorValueHolder.containsKey(type)){
                sensorValueHolder.replace(type,newValue);
            }else{
                sensorValueHolder.put(type,newValue);
            }

            System.out.println("The new Measure value of type " +
                    type.name() +
                    " from " +
                    ((Sensor) p).getLocation() +
                    " " +
                    sensorValueHolder.get(type) +
                    Yardstick.valueOf(type.toString()).getSymbol());


        } else{ // source is THRESHOLD
            if(thresholdValueHolder.containsKey(type)){
                thresholdValueHolder.replace(type,newValue);
            }else{
                thresholdValueHolder.put(type,newValue);
            }

            System.out.println("The new Threshold value is " + type.name() + " " +
                    thresholdValueHolder.get(type) +
                    Yardstick.valueOf(type.toString()).getSymbol());

        }

        check(type);
    }

    private void check(measureType type){
            System.out.println("Threshold Value: " +
                    thresholdValueHolder.get(type) +
                    Yardstick.valueOf(type.toString()).getSymbol());
            if(sensorValueHolder.containsKey(type)) {
                System.out.println("Actual Value: " +
                        sensorValueHolder.get(type) +
                        Yardstick.valueOf(type.toString()).getSymbol());
                if (thresholdValueHolder.get(type) >= sensorValueHolder.get(type)) {
                    System.out.println("Everything normal");
                } else {
                    System.out.println("Threshold Exceeded!!");
                }
            } else {System.out.println("Waiting for a measurement from the sensor");}
    }


}
