package com.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {
    private final int numOfRides;
    private final double totalCost;

    public double getAverageFare() {
        return averageFare;
    }

    private final double averageFare;

    InvoiceSummary(int numOfRides, double totalCost){
        this.numOfRides = numOfRides;
        this.totalCost = totalCost;
        this.averageFare = this.totalCost/this.totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides &&
                Double.compare(that.totalCost, totalCost) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }
}
