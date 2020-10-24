package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = null;
    Ride[] rides = {new Ride(2.0, 5),
            new Ride(0.1, 1)};

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_whenLessThanMinimumFare_shouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5.0, totalFare, 0.00);

    }

    @Test
    public void givenDistanceAndTime_whenMultipleRides_shouldReturnInvoiceSummary() {

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, summary);
        Assert.assertEquals(expectedInvoiceSummary.getAverageFare(), summary.getAverageFare(), 0.0);

    }

    @SuppressWarnings("deprecation")
    @Test
    public void givenUserIdShouldReturnTheListOfRides() {
        RideRepository rideRepository = new RideRepository();
        String id = "1";
        rideRepository.insertNewRider(id, rides);
        Assert.assertEquals(rides, rideRepository.ridesMap.get("1"));
        InvoiceSummary summary = invoiceGenerator.calculateFare(rideRepository.ridesMap.get("1"));
        InvoiceSummary checkSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(summary,checkSummary);
    }


}
