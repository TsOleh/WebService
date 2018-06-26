package com.epam.lab.location;


import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class LocationServiceTest {
    private static final Logger LOGGER = Logger.getLogger(LocationServiceTest.class);
    Friends somfr = new Friends();
    private static LocationService service;

    @BeforeClass
    public static void setUp() {
        LOGGER.info("setting up remote web service");
        service = new LocationServiceImplService().getLocationServiceImplPort();
        LOGGER.info("connection to remote web service successful\n");
    }

    @AfterMethod
    public void afterMethod(ITestResult result, Method method) {
        if (result.getStatus() == ITestResult.FAILURE) {
            LOGGER.error("failed " + method + "\n");
        }
    }

    @Test(priority = 1)
    public void getFriendsByLocationSuccessTest() {
        LOGGER.info("started");
        Response response = service.getFriendsByLocation("cinema");
        assertNotNull(response);
        assertNull(response.getSummaryFault());
        assertNotNull(response.getSummarySuccess());
        // assertTrue(response.getFriends().getValue(), new Friends("Oleh", "Marichka", "Yevhen", "Tolik"));
        LOGGER.info("passed\n");
    }

    @Test(priority = 2)
    public void getFriendsByLocationFaultTest() {
        LOGGER.info("started");
        Response response = service.getFriendsByLocation("restaurant");
        assertNotNull(response);
        assertNull(response.getSummaryFault());
        assertNotNull(response.getSummarySuccess());

        LOGGER.info("passed\n");
    }

    @Test(priority = 3)
    public void getFriendsByCoordinatesSuccessTest() {
        LOGGER.info("started");
        Response response = service.getFriendsByCoordinates(190, 230);
        assertNotNull(response);
        assertNull(response.getSummaryFault());
        assertNotNull(response.getSummarySuccess());

        LOGGER.info("passed\n");
    }

    @Test(priority = 4)
    public void getFriendsByCoordinatesFaultTest() {
        LOGGER.info("started");
        Response response = service.getFriendsByCoordinates(90, 230);
        assertNotNull(response);
        assertNull(response.getSummaryFault());
        assertNotNull(response.getSummarySuccess());

        LOGGER.info("passed\n");
    }

    @Test(priority = 5)
    public void getAllLocationsByDistanceSuccessTest() {
        LOGGER.info("started");
        Response response = service.getAllLocationsByDistance(230);
        assertNotNull(response);
        assertNull(response.getSummaryFault());
        assertNotNull(response.getSummarySuccess());

        LOGGER.info("passed\n");
    }

    @Test(priority = 6)
    public void getAllLocationsByDistanceFaultTest() {
        LOGGER.info("started");
        Response response = service.getAllLocationsByDistance(20);
        assertNotNull(response);
        assertNull(response.getSummaryFault());
        assertNotNull(response.getSummarySuccess());

        LOGGER.info("passed\n");
    }

    //    @Test(priority = 7)
//    public void setNewLocationSuccessTest(){
 //     LOGGER.info("started");
//        Response response = service.setNewLocation(new Locations("park", 200, 180),
//                new Friends(null));
//        assertNotNull(response);
//        assertNull(response.getSummaryFault());
//        assertNotNull(response.getSummarySuccess());
//
//        LOGGER.info("passed\n");
//    }
//
//    @Test(priority = 8)
//    public void setNewLocationFaultTest(){
//    LOGGER.info("started");
//        Response response = service.setNewLocation(new Locations("park", 200, 180),
//                new Friends(null));
//        assertNotNull(response);
//        assertNull(response.getSummaryFault());
//        assertNotNull(response.getSummarySuccess());
//
//        LOGGER.info("passed\n");
//    }
    @Test(priority = 7)
    public void setMyLocationSuccessTest() {
        LOGGER.info("started");
        Response response = service.setMyLocation("pub");
        assertNotNull(response);
        assertNull(response.getSummaryFault());
        assertNotNull(response.getSummarySuccess());

        LOGGER.info("passed\n");
    }
    @Test(priority = 8)
    public void setMyLocationFaultTest() {
        LOGGER.info("started");
        Response response = service.setMyLocation("club");
        assertNotNull(response);
        assertNull(response.getSummaryFault());
        assertNotNull(response.getSummarySuccess());

        LOGGER.info("passed\n");
    }

}
