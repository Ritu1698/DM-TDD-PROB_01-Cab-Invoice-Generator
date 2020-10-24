package com.bridgelabz.cabinvoicegenerator;

public class InvoiceGenerator {
    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;

    public static void main(String args[]) {
        System.out.println("Welcome Message");
    }

    public double calculateFare(double distance, int time) {
        return distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE;
    }
}
