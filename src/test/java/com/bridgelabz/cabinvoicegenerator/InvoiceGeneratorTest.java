package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = null;
    InvoiceSummary summary = null;
    InvoiceSummary expectedSummary = null;
    Ride[] rides_premium = {new Ride(2.0, 5, "premium"),
            new Ride(0.1, 1, "premium")};

    Ride[] rides_normal = {new Ride(2.0, 5, "normal"),
            new Ride(0.1, 1, "normal")};

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateFare(distance, time, "normal");
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_whenLessThanMinimumFare_shouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateFare(distance, time, "normal");
        Assert.assertEquals(5.0, totalFare, 0.00);

    }

    @Test
    public void givenDistanceAndTime_whenMultipleRides_shouldReturnInvoiceSummary() {

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides_normal);
        Assert.assertEquals(expectedInvoiceSummary, summary);
        Assert.assertEquals(expectedInvoiceSummary.getAverageFare(), summary.getAverageFare(), 0.0);

    }

    @SuppressWarnings("deprecation")
    @Test
    public void givenUserIdShould_ReturnTheListOfRides() {
        RideRepository rideRepository = new RideRepository();
        String id = "1";
        rideRepository.insertNewRider(id, rides_normal);
        Assert.assertEquals(rides_normal, rideRepository.ridesMap.get("1"));
        summary = invoiceGenerator.calculateFare(rideRepository.ridesMap.get("1"));
        expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(summary, expectedSummary);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void givenRiderType_ShouldReturnRiderTypeInvoiceSummary() {
        RideRepository rideRepository = new RideRepository();
        String id = "1";
        rideRepository.insertNewRider(id, rides_premium);
        Assert.assertEquals(rides_premium, rideRepository.ridesMap.get("1"));
        summary = invoiceGenerator.calculateFare(rideRepository.ridesMap.get("1"));
        expectedSummary = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(summary, expectedSummary);

    }


}
