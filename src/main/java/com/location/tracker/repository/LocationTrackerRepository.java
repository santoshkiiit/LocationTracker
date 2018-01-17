package com.location.tracker.repository;

import com.location.tracker.data.DriverInformation;
import com.location.tracker.data.LocationTrace;
import com.location.tracker.data.VehicleInformation;


import java.util.Date;
import java.util.List;

public interface LocationTrackerRepository {


    void addLocationTraceForDevice(Long deviceId, Double latitude,
                                   Double longitude, String locationName, Integer speed, String currentTimeStamp, String additionalInfo, String regNumber);

    void addLocationTraceForMobile(String mobileNumber, Double latitude,
                                   Double longitude, String locationName, Integer speed, String currentTimeStamp, String additionalInfo, String regNumber);

    List<LocationTrace> getLocationForDevice(Long deviceId,String fromTime, String toTime);

    List<LocationTrace> getLocationForMobile(String mobileNumber,String fromTime, String toTime);

    void updateVehicleDevice(Long deviceId, String regNumber);

     void addDriver(DriverInformation driverInformation);

     void addVehicleInformation(VehicleInformation vehicleInformation);

}
