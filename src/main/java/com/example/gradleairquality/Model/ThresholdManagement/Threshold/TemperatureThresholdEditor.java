package com.example.gradleairquality.Model.ThresholdManagement.Threshold;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.measureType;
import com.example.gradleairquality.Model.UserManagement.Manager;


import javax.management.InvalidAttributeValueException;

public class TemperatureThresholdEditor extends ThresholdEditor{

    public TemperatureThresholdEditor(Editor nextEditor) {
        super(nextEditor);
    }

    @Override
    public void edit(EditRequest request, Manager manager) {
        try {
            if (request.getType() == measureType.TEMPERATURE) {
                if(request.getNewValue() >= -5 && request.getNewValue() <=40) {
                    ThresholdsMap.
                            getThresholdsInstance(manager)
                            .getThresholds().
                            get(measureType.TEMPERATURE).
                            setThreshold(request.getNewValue());

                }else {throw new InvalidAttributeValueException("The value is out of bound");}

            } else {
                getNextEditor().edit(request,manager);
            }
        } catch(Exception e){
            if(e.getClass() != InvalidAttributeValueException.class) {
                throw new NullPointerException("There is no Editor to handle that request");
            } else{ System.out.println( e.getMessage());}
        }
    }


}
