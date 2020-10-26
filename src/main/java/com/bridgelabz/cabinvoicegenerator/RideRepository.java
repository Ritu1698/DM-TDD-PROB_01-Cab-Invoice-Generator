package com.bridgelabz.cabinvoicegenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    Map<String, Ride[]> ridesMap;

    public RideRepository() {
        this.ridesMap = new HashMap<>();
    }

    public void insertNewRider(String id, Ride[] rides) {
        ridesMap.put(id, rides);
    }

}
