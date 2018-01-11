package com.location.tracker.data;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection="locationTrace")
public class LocationTrace {
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    Long driverId;
    Double longitude;
    Double latitude;
    String locationName;
    Integer speed;
    String  deviceType;
    Long deviceId;
    String mobileNumber;
    String additionalInfo;

    public LocationTrace(Long driverId, String traceTime, Double longitude, Double latitude, String locationName, Integer speed, String deviceType, Long deviceId, String mobileNumber, String additionalInfo) {
        this.driverId = driverId;
        this.traceTime = traceTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationName = locationName;
        this.speed = speed;
        this.deviceType = deviceType;
        this.deviceId = deviceId;
        this.mobileNumber = mobileNumber;
        this.additionalInfo = additionalInfo;
    }


    public String getTraceTime() {
        return traceTime;
    }

    public void setTraceTime(String traceTime) {
        this.traceTime = traceTime;
    }

    String traceTime;

    @Override
    public String toString() {
        return "LocationTrace{" +
                "driverId=" + driverId +
                ", deviceId=" + deviceId +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", locationName='" + locationName + '\'' +
                ", speed=" + speed +
                ", deviceType=" + deviceType +
                "traceTime= "+traceTime+
                '}';
    }



    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public LocationTrace(Long driverId,Long deviceId, Double latitude, Double longitude,  String locationName,Integer speed, String deviceType,  String traceTime, String additionalInfo) {
        this.driverId = driverId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.speed = speed;
        this.locationName = locationName;
        this.deviceType = deviceType;
        this.deviceId = deviceId;
        this.traceTime =traceTime;
        this.additionalInfo = additionalInfo;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getSpeed() {
        return speed;
    }

    public LocationTrace() {
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public LocationTrace(Long driverId, String mobileNumber, Double latitude, Double longitude , String locationName, Integer speed, String deviceType, String traceTime, String additionalInfo) {
        this.driverId = driverId;
        this.mobileNumber = mobileNumber;
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationName = locationName;
        this.speed = speed;
        this.deviceType = deviceType;
        this.traceTime = traceTime;
        this.additionalInfo = additionalInfo;
    }

    public String getDeviceType() {
        return deviceType;

    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }


}
