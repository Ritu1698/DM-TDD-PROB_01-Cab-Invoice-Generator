package com.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {
    private final int numOfRides;
    private final double totalCost;
    private final double averageFare;

    public int getNumOfRides() {
        return numOfRides;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getAverageFare() {
        return averageFare;
    }

    InvoiceSummary(int numOfRides, double totalCost) {
        this.numOfRides = numOfRides;
        this.totalCost = totalCost;
        this.averageFare = this.totalCost / this.totalCost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceSummary other = (InvoiceSummary) obj;
        if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
            return false;
        if (numOfRides != other.numOfRides)
            return false;
        if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
            return false;
        return true;
    }
}
