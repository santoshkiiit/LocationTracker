package com.location.tracker.web.controller;
import com.location.tracker.data.DeviceType;
import com.location.tracker.data.LocationTrace;
import com.location.tracker.repository.DriverInformation;
import com.location.tracker.repository.LocationTrackerRepositoryImpl;
import com.location.tracker.repository.VehicleInformation;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LocationTrackController {


LocationTrackerRepositoryImpl locTrackerRepository = new  LocationTrackerRepositoryImpl();

    public void addDriver(DriverInformation driverInfo){
        locTrackerRepository.addDriver(driverInfo);
    }

    public void addVehicle(VehicleInformation vehicleInfo){
        locTrackerRepository.addVehicleInformation(vehicleInfo);
    }


    public void updateDeviceForVehicle(String regNumber,Long deviced) {
        locTrackerRepository.updateVehicleDevice(deviced, regNumber);
    }



    public void insertDeviceTrace(LocationTrace trace){
        if(trace.getDeviceType().equals(DeviceType.GPS.toString())){
             locTrackerRepository.addLocationTraceForDevice(trace.getDeviceId(), trace.getDriverId(),trace.getLatitude(), trace.getLongitude(),trace.getLocationName(),trace.getSpeed(),getCurrentTimeStamp());

        }else{
             locTrackerRepository.addLocationTraceForMobile(trace.getMobileNumber(), trace.getDriverId(),trace.getLatitude(),trace.getLongitude(),trace.getLocationName(),trace.getSpeed(),getCurrentTimeStamp());


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
