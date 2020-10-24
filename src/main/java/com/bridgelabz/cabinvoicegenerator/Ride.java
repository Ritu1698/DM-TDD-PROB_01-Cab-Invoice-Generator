package com.bridgelabz.cabinvoicegenerator;

public class Ride {
    public double distance;
    public int time;
    public String riderType = "normal";

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }
    public Ride(double distance, int time, String riderType) {
        this.distance = distance;
        this.time = time;
        this.riderType = riderType;
    }
}
