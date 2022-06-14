package com.example.gradleairquality.Model.ThresholdManagement.Sensor;

import java.time.LocalDate;


public class SensorListTest {
    public static void main(String[] args) {

        Sensor prova = new Sensor("Melito Di Napoli", "ABCDEF", 44.06, 57.76);
        Measurer tempSensor = new TemperatureDecorator(prova);
        Measurer humSensor = new HumidityDecorator(prova);
        Measure temp1 = new Measure(measureType.TEMPERATURE, LocalDate.now(), 25);
        Measure temp2 = new Measure(measureType.TEMPERATURE, LocalDate.of(2022, 3, 1), 26);
        Measure hum1 = new Measure(measureType.HUMIDITY, LocalDate.now(), 70);
        tempSensor.addMeasure(temp1);
        tempSensor.addMeasure(temp2);

        humSensor.addMeasure(hum1);
        System.out.println(prova.getMeasures());
        System.out.println(tempSensor.getMeasures());
        System.out.println(humSensor.getMeasures());

        System.out.println(humSensor.getMeasures().get(0).getType());
        System.out.println(humSensor.getMeasures(LocalDate.now()).get(0).getTimestamp());
        System.out.println(humSensor.getMeasures().get(0).getValue() + Yardstick.HUMIDITY.getSymbol());



    }
}
