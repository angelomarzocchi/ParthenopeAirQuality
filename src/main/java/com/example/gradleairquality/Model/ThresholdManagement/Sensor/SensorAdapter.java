package com.example.gradleairquality.Model.ThresholdManagement.Sensor;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SensorAdapter extends TypeAdapter<Sensor> {
    @Override
    public void write(JsonWriter out, Sensor value) throws IOException {
        out.beginObject();
        out.name("location");
        out.value(value.getLocation());
        out.name("online");
        out.value(value.isOnline());
        out.name("code");
        out.value(value.getCode());
        out.name("latitude");
        out.value(value.getLongitude());
        out.name("longitude");
        out.value(value.getLongitude());
        out.name("measures");
        out.value(value.getMeasures().toString());


    }

    @Override
    public Sensor read(JsonReader in) throws IOException {
        String location = null,code = null;
        Boolean online;
        Double latitude = null,longitude = null;
        ArrayList arrayList = new ArrayList<>();
        String arrayToString = null;
        in.beginObject();
        String fieldname = null;
        while(in.hasNext()){
            JsonToken token = in.peek();

            if(token.equals(JsonToken.NAME)) {
                fieldname = in.nextName();
            }
            switch (fieldname){

                case "location":
                    token = in.peek();
                    location = in.nextString();
                    break;
                case "online":
                    token = in.peek();
                    online = in.nextBoolean();
                    break;
                case "code":
                    token = in.peek();
                    code = in.nextString();
                    break;
                case "latitude":
                    token = in.peek();
                    latitude = in.nextDouble();
                    break;
                case "longitude":
                    token = in.peek();
                    longitude = in.nextDouble();
                    break;
                case "measures":
                    token = in.peek();
                    arrayToString = in.nextString();
                    break;
            }

        }

        Sensor sensor = new Sensor(location,code,latitude,longitude);
        Gson gson = new Gson();
        arrayList = gson.fromJson(arrayToString,new TypeToken<ArrayList<Sensor>>() {}.getType());
        assert arrayList != null;
        for (Measure measure : (Iterable<Measure>) arrayList) {
            sensor.addMeasure(measure);
        }

        return sensor;

    }
}
