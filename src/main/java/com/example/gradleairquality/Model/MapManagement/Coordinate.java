package com.example.gradleairquality.Model.MapManagement;

public class Coordinate {
    public Coordinate (Double longitude, Double latitude){
        this.longitude=longitude;
        this.latitude=latitude;
    }
    private final Double longitude;
    private final Double latitude;

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
