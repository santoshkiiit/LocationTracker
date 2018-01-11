package com.location.tracker.service;

import com.location.tracker.data.LocationTrace;
import com.location.tracker.data.DriverInformation;
import com.location.tracker.data.VehicleInformation;
import com.location.tracker.web.controller.LocationTrackController;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/location/tracker")
public class LocationTrackerServiceImpl implements LocationTrackerService {

    @Override
    @RequestMapping(path="/addDriver" ,method = RequestMethod.PUT )
    public void addDriver(@RequestBody DriverInformation driverInformation){
        LocationTrackController locController = new LocationTrackController();
        locController.addDriver(driverInformation);
    }

    @Override
    @RequestMapping(path="/addVehicle" ,method = RequestMethod.PUT )
    public void addVehicle(@RequestBody VehicleInformation vehicleInformation){
        LocationTrackController locController = new LocationTrackController();
        locController.addVehicle(vehicleInformation);
    }


    @Override
    @RequestMapping(path="/updateVehicleDevice" ,method = RequestMethod.POST)
    public void updateDeviceForVehicle(@RequestParam("regNumber") String regNumber, @RequestParam("deviceId") Long deviceId){
        LocationTrackController locController = new LocationTrackController();
        locController.updateDeviceForVehicle(regNumber, deviceId);
    }


    @Override
    @RequestMapping(path="/insertTracePoint" ,method = RequestMethod.PUT )
    public  void updateDevicelocation(@RequestBody LocationTrace locTrace){
        LocationTrackController controller = new LocationTrackController();
        controller.updateDevicelocation(locTrace);
    }

    @Override
    @RequestMapping(path="/deviceLocation" ,method = RequestMethod.GET )
    public List<LocationTrace> getLocationLogForDevice(@RequestParam("deviceId") Long deviceId,  @RequestParam("fromTime") String fromTime, @RequestParam("toTime") String toTime){

        LocationTrackController locController = new LocationTrackController();
        return locController.getLocationLogForDevice(deviceId,fromTime, toTime);
    }

    @Override
    @RequestMapping(path="/mobileLocation" ,method = RequestMethod.GET )
    public List<LocationTrace> getLocationLogForMobile(@RequestParam("mobileNumber") String mobileNumber,  @RequestParam("fromTime") String fromTime, @RequestParam("toTime") String toTime){
        LocationTrackController locController = new LocationTrackController();
        return  locController.getLocationLogForMobile(mobileNumber ,fromTime, toTime);
    }




}
