package com.location.tracker.repository;

import com.location.tracker.data.DeviceType;
import com.location.tracker.data.DriverInformation;
import com.location.tracker.data.LocationTrace;

import java.util.Date;
import java.util.List;

import com.location.tracker.data.VehicleInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@ComponentScan
@Repository
public class LocationTrackerRepositoryImpl implements LocationTrackerRepository {



//    @Autowired
    MongoDbUtils mongoDbUtils= new MongoDbUtils();



    @Override
    public void addVehicleInformation(VehicleInformation vehicleInformation){
        MongoOperations mongoOps=  mongoDbUtils.getDbConnection("locationTracker");
        mongoOps.insert(vehicleInformation);

    }

    @Override
    public void addDriver(DriverInformation driverInformation){
        MongoOperations mongoOps=  mongoDbUtils.getDbConnection("locationTracker");
        mongoOps.insert(driverInformation);

    }

    @Override
    public void updateVehicleDevice(Long deviceId, String regNumber){
        MongoOperations mongoOps=  mongoDbUtils.getDbConnection("locationTracker");
        Query searchVehicleQuery= new Query(Criteria.where("regNumber").is(regNumber));
        mongoOps.updateFirst(searchVehicleQuery,
                Update.update("deviceId", deviceId),VehicleInformation.class);

    }





   public void addLocationTraceForDevice(Long deviceId, Double latitude,
                                         Double longitude, String locationName, Integer speed, String currentTimeStamp, String additionalInfo, String regNumber){
        MongoOperations mongoOps=  mongoDbUtils.getDbConnection("locationTracker");
        mongoOps.insert(new LocationTrace(deviceId,latitude,longitude, locationName, speed, DeviceType.GPS.toString(),currentTimeStamp,additionalInfo, regNumber));



    }

    @Override
    public void addLocationTraceForMobile(String mobileNumber, Double latitude,
                                          Double longitude, String locationName, Integer speed, String currentTimeStamp, String additionalInfo, String regNumber){

        MongoOperations mongoOps=  mongoDbUtils.getDbConnection("locationTracker");
         mongoOps.insert(new LocationTrace(mobileNumber,latitude,longitude, locationName, speed, DeviceType.MOBILE.toString(),currentTimeStamp, additionalInfo, regNumber));

    }

    @Override
    public List<LocationTrace> getLocationForDevice(Long deviceId,String fromTime, String toTime){
        MongoOperations mongoOps=  mongoDbUtils.getDbConnection("locationTracker");
        Query query = new Query();
        query.addCriteria(where("deviceId").is(deviceId));
        query.addCriteria(where("traceTime").gt(fromTime).lt(toTime));
        List<LocationTrace> locationTracePoints = mongoOps.find(query, LocationTrace.class);
        return  locationTracePoints;

    }


    @Override
    public List<LocationTrace> getLocationForMobile(String mobileNumber,String fromTime, String toTime){
        MongoOperations mongoOps=  mongoDbUtils.getDbConnection("locationTracker");
        Query query = new Query();
        query.addCriteria(where("mobileNumber").is(mobileNumber));
        query.addCriteria(where("traceTime").gt(fromTime).lt(toTime));
        List<LocationTrace> locationTracePoints = mongoOps.find(query,LocationTrace.class);
        return  locationTracePoints;
    }


}
