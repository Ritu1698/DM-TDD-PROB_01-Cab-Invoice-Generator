package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.bridgelabz.cabinvoicegenerator.Ride.TypesOfRider;

import java.util.ArrayList;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = null;
    InvoiceSummary summary = null;
    InvoiceSummary expectedSummary = null;
    ArrayList<Ride> rideArrayListPremium = null;
    ArrayList<Ride> rideArrayListNormal = null;
    ArrayList<Ride> rideArrayList = null;

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
        rideArrayListPremium = new ArrayList<>();
        rideArrayListNormal = new ArrayList<>();
        rideArrayList = new ArrayList<>();
        rideArrayListNormal.add(new Ride(2.0, 5, TypesOfRider.NORMAL));
        rideArrayListNormal.add(new Ride(0.1, 1, TypesOfRider.NORMAL));
        rideArrayListPremium.add(new Ride(2.0, 5, TypesOfRider.PREMIUM));
        rideArrayListPremium.add(new Ride(0.1, 1, TypesOfRider.PREMIUM));
        rideArrayList.add(new Ride(2.0, 5, TypesOfRider.NORMAL));
        rideArrayList.add(new Ride(0.1, 1, TypesOfRider.NORMAL));
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateFare(distance, time, TypesOfRider.NORMAL);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_whenLessThanMinimumFare_shouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateFare(distance, time, TypesOfRider.NORMAL);
        Assert.assertEquals(5.0, totalFare, 0.00);

    }

    @Test
    public void givenDistanceAndTime_whenMultipleRides_shouldReturnInvoiceSummary() {

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rideArrayListNormal);
        Assert.assertEquals(expectedInvoiceSummary, summary);
        Assert.assertEquals(expectedInvoiceSummary.getAverageFare(), summary.getAverageFare(), 0.0);

    }

    @Test
    public void givenUserIdShould_ReturnTheListOfRides() {
        RideRepository rideRepository = new RideRepository();
        String id = "1";
        rideRepository.addNewRider(id, rideArrayListNormal);
        Assert.assertEquals(rideArrayListNormal, rideRepository.getRides("1"));
        summary = invoiceGenerator.calculateFare(rideRepository.getRides("1"));
        expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(summary, expectedSummary);
        rideArrayListNormal.add(new Ride(2.0, 5, TypesOfRider.NORMAL));
        rideArrayListNormal.add(new Ride(0.1, 1, TypesOfRider.NORMAL));
        rideRepository.addNewRider(id, rideArrayList);
        Assert.assertEquals(rideArrayListNormal, rideRepository.getRides("1"));
    }

    @Test
    public void givenRiderType_ShouldReturnRiderTypeInvoiceSummary() {
        RideRepository rideRepository = new RideRepository();
        String id = "1";
        rideRepository.addNewRider(id, rideArrayListPremium);
        Assert.assertEquals(rideArrayListPremium, rideRepository.getRides("1"));
        summary = invoiceGenerator.calculateFare(rideRepository.getRides("1"));
        expectedSummary = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(summary, expectedSummary);

    }
}
