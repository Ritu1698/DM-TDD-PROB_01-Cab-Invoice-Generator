package com.bridgelabz.cabinvoicegenerator;

import java.util.*;

public class RideRepository {
    Map<String, ArrayList<Ride>> rideMap;

    public RideRepository() {
        this.rideMap = new HashMap<>();
    }

    public void addNewRider(String id, ArrayList<Ride> rides) {
        if (rideMap.get(id) == null)
            rideMap.put(id, rides);
        else {
            ArrayList<Ride> userRidesList;
            userRidesList = rideMap.get(id);
            userRidesList.addAll(rides);
            rideMap.replace(id, userRidesList);
        }
    }

    public ArrayList<Ride> getRides(String userId) {
        return rideMap.getOrDefault(userId, null);
    }

}
