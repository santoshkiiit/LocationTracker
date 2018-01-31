package com.location.tracker.service;

import com.location.tracker.data.LocationTrace;
import com.location.tracker.data.DriverInformation;
import com.location.tracker.data.VehicleInformation;
import com.location.tracker.web.controller.LocationTrackController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/location/tracker")
public class LocationTrackerServiceImpl implements LocationTrackerService {

    @Autowired
    LocationTrackController locController;

    @Override
    @RequestMapping(path="/addDriver" ,method = RequestMethod.PUT )
    public void addDriver(@RequestBody DriverInformation driverInformation){
        locController.addDriver(driverInformation);
    }

    @Override
    @RequestMapping(path="/addVehicle" ,method = RequestMethod.PUT )
    public void addVehicle(@RequestBody VehicleInformation vehicleInformation){
        locController.addVehicle(vehicleInformation);
    }


    @Override
    @RequestMapping(path="/updateVehicleDevice" ,method = RequestMethod.POST)
    public void updateDeviceForVehicle(@RequestParam("regNumber") String regNumber, @RequestParam("deviceId") Long deviceId){
        locController.updateDeviceForVehicle(regNumber, deviceId);
    }


    @Override
    @RequestMapping(path="/insertTracePoint" ,method = RequestMethod.PUT )
    public  String updateDevicelocation(@RequestBody LocationTrace locTrace){
        return locController.updateDevicelocation(locTrace);
    }




    @Override
    @RequestMapping(path="/getLog" ,method = RequestMethod.GET )
    public List<LocationTrace> getLocationLogForMobile(@RequestParam(value = "mobileNumber", required = false) String mobileNumber,@RequestParam(value = "deviceId", required = false)Long deviceId,  @RequestParam("fromTime") String fromTime, @RequestParam("toTime") String toTime){
        if(mobileNumber!=null){
            return  locController.getLocationLogForMobile(mobileNumber ,fromTime, toTime);

        }else{
            return  locController.getLocationLogForDevice(deviceId, fromTime, toTime);
        }

    }






}
