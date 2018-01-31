package com.location.tracker.web.controller;
import com.location.tracker.data.DeviceType;
import com.location.tracker.data.LocationTrace;
import com.location.tracker.data.DriverInformation;
import com.location.tracker.repository.LocationTrackerRepositoryImpl;
import com.location.tracker.data.VehicleInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Component
public class LocationTrackController {

    @Autowired
    LocationTrackerRepositoryImpl locTrackerRepository;

    public void addDriver(DriverInformation driverInfo){
        locTrackerRepository.addDriver(driverInfo);
    }

    public void addVehicle(VehicleInformation vehicleInfo){
        locTrackerRepository.addVehicleInformation(vehicleInfo);
    }


    public void updateDeviceForVehicle(String regNumber,Long deviced) {
        locTrackerRepository.updateVehicleDevice(deviced, regNumber);
    }



    public String updateDevicelocation(LocationTrace trace){
        if(trace.getDeviceType().equals(DeviceType.GPS.toString())){
             locTrackerRepository.addLocationTraceForDevice(trace.getDeviceId(), trace.getLatitude(), trace.getLongitude(),trace.getLocationName(),trace.getSpeed(),getCurrentTimeStamp(),trace.getAdditionalInfo(),trace.getRegNumber());
                return "Updated record";
        }else if(trace.getDeviceType().equals(DeviceType.MOBILE.toString())){
             locTrackerRepository.addLocationTraceForMobile(trace.getMobileNumber(),trace.getLatitude(),trace.getLongitude(),trace.getLocationName(),trace.getSpeed(),getCurrentTimeStamp(),trace.getAdditionalInfo(),trace.getRegNumber());
            return "Updated record";

        }else{
            return "UPDATE FAILED-- INCORRECT DEVICE TYPE";
        }
    }

    public List<LocationTrace> getLocationLogForDevice(Long deviceId,String fromTime,String toTime){
        return  locTrackerRepository.getLocationForDevice(deviceId, fromTime, toTime);
    }


    public List<LocationTrace> getLocationLogForMobile(String mobileNumber,String fromTime,String toTime){
        return   locTrackerRepository.getLocationForMobile(mobileNumber, fromTime, toTime );
    }

    public String getCurrentTimeStamp(){


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);

    }








}
