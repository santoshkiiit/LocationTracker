package com.location.tracker.repository;

import com.location.tracker.data.LocationTrace;


import java.util.List;

public interface LocationTrackerRepository {


    void addLocationTraceForDevice(long deviceId, Long driverId, Double latitude,
                                      Double longitude, String locationName, Integer speed, String currentTimeStamp);

    void addLocationTraceForMobile(String mobileNumber, Long driverId, Double latitude,
                                      Double longitude, String locationName, Integer speed, String currentTimeStamp);
    List<LocationTrace> getLocationForDevice(Long deviceId,String fromTime, String toTime);

    List<LocationTrace> getLocationForMobile(String mobileNumber,String fromTime, String toTime);

    void updateVehicleDevice(Long deviceId, String regNumber);

     void addDriver(DriverInformation driverInformation);

     void addVehicleInformation(VehicleInformation vehicleInformation);

}
