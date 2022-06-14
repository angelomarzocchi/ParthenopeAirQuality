package com.example.gradleairquality.Model.ThresholdManagement.Threshold;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.measureType;
import com.example.gradleairquality.Model.UserManagement.Manager;


import javax.management.InvalidAttributeValueException;

public class PM10ThresholdEditor extends ThresholdEditor{
    public PM10ThresholdEditor(Editor nextEditor) {
        super(nextEditor);
    }

    @Override
    public void edit(EditRequest request, Manager manager) {
        try {
            if (request.getType() == measureType.PM10) {
                if(request.getNewValue() >= 0 && request.getNewValue() <=500) {
                    ThresholdsMap.
                            getThresholdsInstance(manager)
                            .getThresholds().
                            get(measureType.PM10).
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
