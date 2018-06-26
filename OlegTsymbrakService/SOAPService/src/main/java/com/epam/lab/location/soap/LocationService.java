package com.epam.lab.location.soap;

import com.epam.lab.location.models.Friends;
import com.epam.lab.location.models.Locations;
import com.epam.lab.location.models.Response;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LocationService {

    @WebMethod
    Response getFriendsByLocation(String location);

    @WebMethod
    Response getFriendsByCoordinates(int x,int y);

    @WebMethod
    Response getAllLocationsByDistance(int distance);

    @WebMethod
    void getMyCoordinates();

    @WebMethod
    Response setNewLocation(Locations loc, Friends fr);

    @WebMethod
    Response setMyLocation(String location);
}
