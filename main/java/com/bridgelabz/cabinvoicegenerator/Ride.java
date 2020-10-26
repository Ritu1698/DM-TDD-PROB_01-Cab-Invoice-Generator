package com.bridgelabz.cabinvoicegenerator;

public class Ride {
    public double distance;
    public int time;
    public TypesOfRider typeOfRider;

    enum TypesOfRider {
        PREMIUM, NORMAL
    }

    public Ride(double distance, int time, TypesOfRider typeOfRider) {
        this.distance = distance;
        this.time = time;
        this.typeOfRider = typeOfRider;
    }
}
