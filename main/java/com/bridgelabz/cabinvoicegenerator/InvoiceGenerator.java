package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;

public class InvoiceGenerator {
    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double MINIMUM_FARE = 5.0;
    private static final int COST_PER_MINUTE_PREMIUM = 2;
    private static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15.0;
    private static final double MINIMUM_FARE_PREMIUM = 20.0;

    public static void main(String args[]) {
        System.out.println("Welcome Message");
    }

    public double normalFareCalculation(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double permiumFareCalculation(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_MINUTE_PREMIUM;
        return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
    }

    public double calculateFare(double distance, int time, Ride.TypesOfRider typesOfRider) {
        if (typesOfRider == Ride.TypesOfRider.NORMAL) {
            return normalFareCalculation(distance, time);
        } else {
            return permiumFareCalculation(distance, time);
        }
    }

    public InvoiceSummary calculateFare(ArrayList<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time, ride.typeOfRider);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }

}
