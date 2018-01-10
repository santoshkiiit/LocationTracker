package com.location.tracker.repository;

import com.location.tracker.data.DeviceType;
import com.location.tracker.data.DriverInformation;
import com.location.tracker.data.LocationTrace;
import java.util.List;

import com.location.tracker.data.VehicleInformation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.MongoOperations;

public class LocationTrackerRepositoryImpl implements LocationTrackerRepository {

    @Override
    public void addVehicleInformation(VehicleInformation vehicleInformation){
        MongoDbUtils mongoUtils = new MongoDbUtils();
        MongoOperations mongoOps=  mongoUtils.getDbConnection("locationTracker");
        mongoOps.insert(vehicleInformation);

    }

    @Override
    public void addDriver(DriverInformation driverInformation){
        MongoDbUtils mongoUtils = new MongoDbUtils();
        MongoOperations mongoOps=  mongoUtils.getDbConnection("locationTracker");
        mongoOps.insert(driverInformation);

    }

    @Override
    public void updateVehicleDevice(Long deviceId, String regNumber){
        MongoDbUtils mongoUtils = new MongoDbUtils();
        MongoOperations mongoOps=  mongoUtils.getDbConnection("locationTracker");
        Query searchVehicleQuery= new Query(Criteria.where("regNumber").is(regNumber));
        mongoOps.updateFirst(searchVehicleQuery,
                Update.update("deviceId", deviceId),VehicleInformation.class);

    }

    @Override
   public void addLocationTraceForDevice(long deviceId, Long driverId, Double latitude,
                                            Double longitude, String locationName, Integer speed, String currentTimeStamp){
         MongoDbUtils mongoUtils = new MongoDbUtils();

          MongoOperations mongoOps=  mongoUtils.getDbConnection("locationTracker");

        mongoOps.insert(new LocationTrace(driverId,deviceId,null,latitude,longitude, locationName, speed, DeviceType.GPS.toString(),currentTimeStamp));

    }

    @Override
    public void addLocationTraceForMobile(String mobileNumber, Long driverId, Double latitude,
                                             Double longitude, String locationName, Integer speed, String currentTimeStamp){
         MongoDbUtils mongoUtils = new MongoDbUtils();
         MongoOperations mongoOps=  mongoUtils.getDbConnection("locationTracker");
         mongoOps.insert(new LocationTrace(driverId,null,mobileNumber,latitude,longitude, locationName, speed, DeviceType.MOBILE.toString(),currentTimeStamp));

    }

    @Override
    public List<LocationTrace> getLocationForDevice(Long deviceId,String fromTime, String toTime){
        MongoDbUtils mongoUtils = new MongoDbUtils();
        MongoOperations mongoOps=  mongoUtils.getDbConnection("locationTracker");
        Query query = new Query();
        query.addCriteria(where("deviceId").is(deviceId));
        query.addCriteria(where("traceTime").gt(fromTime).lt(toTime));
        List<LocationTrace> locationTracePoints = mongoOps.find(query, LocationTrace.class);
        return  locationTracePoints;

    }


    @Override
    public List<LocationTrace> getLocationForMobile(String mobileNumber,String fromTime, String toTime){
        MongoDbUtils mongoUtils = new MongoDbUtils();
        MongoOperations mongoOps=  mongoUtils.getDbConnection("locationTracker");
        Query query = new Query();
        query.addCriteria(where("mobileNumber").is(mobileNumber));
        query.addCriteria(where("traceTime").gt(fromTime).lt(toTime));
        List<LocationTrace> locationTracePoints = mongoOps.find(query,LocationTrace.class);
        return  locationTracePoints;
    }


}
