
package com.epam.lab.location;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import com.epam.lab.location.soap.Friends;
import com.epam.lab.location.soap.Locations;
import com.epam.lab.location.soap.ObjectFactory;
import com.epam.lab.location.soap.Response;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LocationService", targetNamespace = "http://soap.location.lab.epam.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LocationService {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.epam.lab.location.soap.Response
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://soap.location.lab.epam.com/LocationService/getAllLocationsByDistanceRequest", output = "http://soap.location.lab.epam.com/LocationService/getAllLocationsByDistanceResponse")
    public Response getAllLocationsByDistance(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.epam.lab.location.soap.Response
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://soap.location.lab.epam.com/LocationService/getFriendsByCoordinatesRequest", output = "http://soap.location.lab.epam.com/LocationService/getFriendsByCoordinatesResponse")
    public Response getFriendsByCoordinates(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.epam.lab.location.soap.Response
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://soap.location.lab.epam.com/LocationService/getFriendsByLocationRequest", output = "http://soap.location.lab.epam.com/LocationService/getFriendsByLocationResponse")
    public Response getFriendsByLocation(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     */
    @WebMethod
    @Action(input = "http://soap.location.lab.epam.com/LocationService/getMyCoordinatesRequest", output = "http://soap.location.lab.epam.com/LocationService/getMyCoordinatesResponse")
    public void getMyCoordinates();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.epam.lab.location.soap.Response
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://soap.location.lab.epam.com/LocationService/setMyLocationRequest", output = "http://soap.location.lab.epam.com/LocationService/setMyLocationResponse")
    public Response setMyLocation(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.epam.lab.location.soap.Response
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://soap.location.lab.epam.com/LocationService/setNewLocationRequest", output = "http://soap.location.lab.epam.com/LocationService/setNewLocationResponse")
    public Response setNewLocation(
        @WebParam(name = "arg0", partName = "arg0")
        Locations arg0,
        @WebParam(name = "arg1", partName = "arg1")
        Friends arg1);

}