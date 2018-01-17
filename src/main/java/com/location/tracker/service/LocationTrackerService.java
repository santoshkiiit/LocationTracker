package com.location.tracker.service;

import java.util.Date;
import java.util.List;
import com.location.tracker.data.LocationTrace;
import com.location.tracker.data.DriverInformation;
import com.location.tracker.data.VehicleInformation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/location/tracker")
public interface LocationTrackerService {

    @RequestMapping(path="/addVehicle" ,method = RequestMethod.PUT )
    public void addVehicle(@RequestBody VehicleInformation vehicleInformation);

    @RequestMapping(path="/addDriver" ,method = RequestMethod.PUT )
    public void addDriver(@RequestBody DriverInformation driverInformation);

    @RequestMapping(path="/updateVehicleDevice" ,method = RequestMethod.POST )
    public void updateDeviceForVehicle(@RequestParam("regNumber") String regNumber, @RequestParam("deviceId") Long deviceId);

    @RequestMapping(path="/insertTracePoint" ,method = RequestMethod.PUT )
    public String updateDevicelocation(@RequestBody LocationTrace locTrace);

    @RequestMapping(path="/getLog" ,method = RequestMethod.GET )
    List<LocationTrace> getLocationLogForMobile(@RequestParam("mobileNumber") String mobileNumber, @RequestParam("deviceId") Long deviceId, @RequestParam("fromTime") String fromTime, @RequestParam("toTime") String toTime);
}
