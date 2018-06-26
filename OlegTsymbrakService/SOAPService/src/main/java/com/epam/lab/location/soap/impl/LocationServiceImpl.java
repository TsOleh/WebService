package com.epam.lab.location.soap.impl;

import com.epam.lab.location.models.*;
import com.epam.lab.location.soap.LocationService;
import org.apache.log4j.Logger;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "com.epam.lab.location.soap.LocationService")
public class LocationServiceImpl implements LocationService {
    private static final Logger LOGGER = Logger.getLogger(LocationServiceImpl.class);
    Locations locations;
    MyLocation myLocation;

    private Map<Locations, Friends> locationFriends;
    private int x;
    private int y;
    private int myX;
    private int myY;
    private int resultX;
    private int resultY;
    private int distanceBetweenPoints;
    private String loc = "";

    {
        locationFriends = new HashMap<>();
        locationFriends.put(new Locations("cafe", 50, 60),
                new Friends("Taras", "Andrew"));
        locationFriends.put(new Locations("pub", 90, 120),
                new Friends("Bohdan"));
        locationFriends.put(new Locations("hotel", 135, 150),
                new Friends("Olenka", "Tanya", "Vitalik"));
        locationFriends.put(new Locations("cinema", 190, 230),
                new Friends("Oleh", "Marichka", "Yevhen", "Tolik"));
        locationFriends.put(new Locations("museum", 220, 275),
                new Friends("Bohdan", "Oleksiy", "Monika", "Viktor"));
    }

    public LocationServiceImpl() {
        locations = new Locations();
    }

    @Override
    public Response getFriendsByLocation(String location) {
        for (Map.Entry<Locations, Friends> item : locationFriends.entrySet()) {
            if (item.getKey().getLocation() == location) {
                LOGGER.info(item.getValue().toString());
                return Response.success(new Friends(item.getValue()));
            }
        }
        return Response.fault(String.format("There are no any friends in location %s", location));
    }


    @Override
    public Response getFriendsByCoordinates(int x, int y) {
        for (Map.Entry<Locations, Friends> item : locationFriends.entrySet()) {
            this.x = item.getKey().getX();
            this.y = item.getKey().getY();
            if (this.x == x && this.y == y) {
                return Response.success(item.getValue());
            }
        }
        return Response.fault(String.format("There are no any friends at the coordinates x=%d; y=%d", x, y));
    }

    @Override
    public Response getAllLocationsByDistance(int distance) {
        getMyCoordinates();
        for (Map.Entry<Locations, Friends> item : locationFriends.entrySet()) {
            x = item.getKey().getX();
            y = item.getKey().getY();
            if (myX == x && myY == y) {
                continue;
            }
            resultX = myX >= x ? myX - x : x - myX;
            resultY = myY >= y ? myY - y : y - myY;
            distanceBetweenPoints = (int) Math.sqrt(Math.pow(resultX, 2) + Math.pow(resultY, 2));
            if (distanceBetweenPoints <= distance) {
                loc += item.getKey().getLocation() + "\n";
            }
        }
        if (loc.isEmpty()) {
            return Response.fault(String.format("There are no any locations at distance of %d meters", distance));
        }
        return Response.success(String.format("At a distance of %d meters are the following locations \n%s", distance, loc));
    }

    @Override
    public void getMyCoordinates() {
        for (Map.Entry<Locations, Friends> item : locationFriends.entrySet()) {
            if (item.getKey().getLocation() == myLocation.getLocation()) {
                myX = item.getKey().getX();
                myY = item.getKey().getY();
            }
        }
    }

    @Override
    public Response setNewLocation(Locations loc, Friends fr) {
        locationFriends.put(loc, fr);
        for (Map.Entry<Locations, Friends> item : locationFriends.entrySet()) {
            if (item.getKey().getLocation() == loc.getLocation()) {
                return Response.success(String.format("%s location was set successfully", loc));
            }
        }
        return Response.fault(String.format("%s location was not set!", loc));
    }

    @Override
    public Response setMyLocation(String location) {
        myLocation = new MyLocation(location);
        return Response.success(String.format("My location is %s", location));
    }
}
