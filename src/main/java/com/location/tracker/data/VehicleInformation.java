package com.location.tracker.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="vehicleInformation")
public class VehicleInformation {

    @Id
    public String regNumber;
    public Long deviceId;
    public Integer capacity;
    public Long driverId;

    public VehicleInformation(String regNumber, Long deviceId, Integer capacity, Long driverId) {
        this.regNumber = regNumber;
        this.deviceId = deviceId;
        this.capacity = capacity;
        this.driverId = driverId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }



    public String getRegNumber() {
        return regNumber;
    }


    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public VehicleInformation() {
    }

    public Long getTrackingDeviceId() {
        return deviceId;
    }

    public void setTrackingDeviceId(Long trackingDeviceId) {
        this.deviceId = trackingDeviceId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "VehicleInformation{" +
                "regNumber='" + regNumber + '\'' +
                ", trackingDeviceId='" + deviceId.toString() + '\'' +
                ", capacity=" + capacity +
                ", driverId=" + driverId +
                '}';
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
