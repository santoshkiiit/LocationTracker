package com.location.tracker;


import com.location.tracker.data.LocationTrace;
import com.location.tracker.data.VehicleInformation;
import com.location.tracker.web.controller.LocationTrackController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest(classes = LocationTrackerApplication.class)
public class LocationTrackerTest {

    LocationTrackController locationTrackController = new LocationTrackController();
    Long mockDeviceID = new Random().nextLong();
    Double mockLatitude = new Random().nextDouble();
    Double mockLongitude = new Random().nextDouble();
    String mockLocationName = "testLocation";
    String mockMobileNumber = "56234534";
    String mockRegNumber = "AG6235463";
    String recordInsertStatus = "Updated record";



    @Test
    public void testInsertAndGetLocationForMobile() {

        String mockFromTime = locationTrackController.getCurrentTimeStamp();
        LocationTrace trace = new LocationTrace(mockMobileNumber, mockLatitude, mockLongitude, mockLocationName, 5, "MOBILE", mockFromTime, "test", mockRegNumber);



        String resultStatus = locationTrackController.updateDevicelocation(trace);



        Assert.assertTrue(resultStatus.equals(recordInsertStatus));

        String mockToTime = locationTrackController.getCurrentTimeStamp();
        List<LocationTrace> mockLocTraceList = locationTrackController.getLocationLogForMobile(mockMobileNumber, mockFromTime, locationTrackController.getCurrentTimeStamp());

        Assert.assertTrue(mockLocTraceList.size() > 0);
        Assert.assertTrue(mockLocTraceList.get(0).getLocationName().equals(mockLocationName));
        Assert.assertTrue(mockLocTraceList.get(0).getRegNumber().equals(mockRegNumber));
        Assert.assertTrue(mockLocTraceList.get(0).getMobileNumber().equals(mockMobileNumber));


    }


    @Test
    public void testInsertAndGetLocationForDevice(){

        String mockFromTime  = locationTrackController.getCurrentTimeStamp();
        LocationTrace trace = new LocationTrace(mockDeviceID, mockLatitude,mockLongitude,mockLocationName,5,"GPS",mockFromTime,"test",mockRegNumber);
        String mockToTime  =locationTrackController.getCurrentTimeStamp();



        String resultStatus = locationTrackController.updateDevicelocation(trace);

        Assert.assertTrue(resultStatus.equals(recordInsertStatus));

        List<LocationTrace> mockLocTraceList = locationTrackController.getLocationLogForDevice(mockDeviceID, mockFromTime, locationTrackController.getCurrentTimeStamp());

        Assert.assertTrue(mockLocTraceList.size()>0);

        Assert.assertTrue(mockLocTraceList.get(0).getLocationName().equals(mockLocationName));

        Assert.assertTrue(mockLocTraceList.get(0).getRegNumber().equals(mockRegNumber));

        Assert.assertTrue(mockLocTraceList.get(0).getDeviceId().equals(mockDeviceID));

    }

    @Test
    public void shouldFailInsertForIncorrectDevicType(){

        String mockFromTime  = locationTrackController.getCurrentTimeStamp();
        LocationTrace trace = new LocationTrace(mockDeviceID, mockLatitude,mockLongitude,mockLocationName,5,"TEST_DEVICE",mockFromTime,"test",mockRegNumber);
        String mockToTime  =locationTrackController.getCurrentTimeStamp();



        String resultStatus = locationTrackController.updateDevicelocation(trace);

        Assert.assertTrue(!resultStatus.equals(recordInsertStatus));

        List<LocationTrace> mockLocTraceList = locationTrackController.getLocationLogForDevice(mockDeviceID, mockFromTime, mockToTime);

        Assert.assertTrue(mockLocTraceList.size()==0);



    }
}
