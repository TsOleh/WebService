package com.epam.lab.location;


import com.epam.lab.location.soap.impl.LocationServiceImpl;

import javax.xml.ws.Endpoint;

public class MainClass {
    //impl service;

    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8080/locationService", new LocationServiceImpl());
        //  impl service = new impl();
//        service.setMyLocation("pub");
//      //  System.out.println(service.getFriendsByLocation("cinema").toString());
//        System.out.println(service.getAllLocationsByDistance(170));
//        System.out.println(service.getFriendsByCoordinates(190, 230).toString());
//        service.setNewLocation(new Locations("park", 200, 180),
//                new Friends(null));

    }
}
