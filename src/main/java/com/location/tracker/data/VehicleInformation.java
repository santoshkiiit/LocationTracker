package com.location.tracker.data;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="vehicleInformation")
public class VehicleInformation {

    public String regNumber;
    public Long trackingDeviceId;
    public Integer capacity;
    public Integer driverId;

    public VehicleInformation(String regNumber, Long trackingDeviceId, Integer capacity, Integer driverId) {
        this.regNumber = regNumber;
        this.trackingDeviceId = trackingDeviceId;
        this.capacity = capacity;
        this.driverId = driverId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }



    public String getRegNumber() {
        return regNumber;
    }


    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Long getTrackingDeviceId() {
        return trackingDeviceId;
    }

    public void setTrackingDeviceId(Long trackingDeviceId) {
        this.trackingDeviceId = trackingDeviceId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "VehicleInformation{" +
                "regNumber='" + regNumber + '\'' +
                ", trackingDeviceId='" + trackingDeviceId.toString() + '\'' +
                ", capacity=" + capacity +
                ", driverId=" + driverId +
                '}';
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
