package com.example.gradleairquality.Model.CompareManagement;
import com.example.gradleairquality.Model.ThresholdManagement.Sensor.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SensorComparatorTest {
    public static void main(String[] args){
        Sensor sensor1 = new Sensor("Melito di Napoli","abc",15.26,71.21);
        Sensor sensor2 = new Sensor("Giugliano in Campania","abd",17.25,80.41);
        HumidityDecorator humSensor1 = new HumidityDecorator(sensor1);
        HumidityDecorator humSensor2 = new HumidityDecorator(sensor2);
        TemperatureDecorator tempSensor1 = new TemperatureDecorator(sensor1);
        TemperatureDecorator tempSensor2 = new TemperatureDecorator(sensor2);

        tempSensor1.addMeasure(new Measure(measureType.TEMPERATURE,LocalDate.now(),20));
        tempSensor2.addMeasure(new Measure(measureType.TEMPERATURE,LocalDate.now(),30));
        humSensor1.addMeasure(new Measure(measureType.HUMIDITY, LocalDate.now(),60));
        /*
        humSensor1.addMeasure(new Measure(measureType.HUMIDITY, LocalDate.now(),70));
        humSensor1.addMeasure(new Measure(measureType.HUMIDITY, LocalDate.now(),80));

         */
        humSensor2.addMeasure(new Measure(measureType.HUMIDITY, LocalDate.now(),70));
        List<Sensor> list = new ArrayList<>();
        list.add(sensor1);
        list.add(sensor2);

        AreaEstimator areaEstimator = new AreaEstimator(list);
        Map<measureType,Double> averages = areaEstimator.getAverages();
        System.out.println("Media umidità: " + averages.get(measureType.HUMIDITY) + Yardstick.HUMIDITY.getSymbol());
        System.out.println("Media Temperatura " + averages.get(measureType.TEMPERATURE) + Yardstick.TEMPERATURE.getSymbol());


        /*
        humSensor2.addMeasure(new Measure(measureType.HUMIDITY, LocalDate.now(),65));
        humSensor2.addMeasure(new Measure(measureType.HUMIDITY, LocalDate.now(),85));
        humSensor2.addMeasure(new Measure(measureType.HUMIDITY,LocalDate.now(),70));


         */
        /*
        SensorComparator comparator = new SensorComparator(humSensor1,humSensor2);
        List<Comparison> comparisonList = comparator.compare();

        for(Comparison e: comparisonList){
            System.out.println(e);
        }

         */



    }
}
