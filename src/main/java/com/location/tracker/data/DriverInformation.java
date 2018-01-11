package com.location.tracker.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="driverInformation")
public class DriverInformation {
    @Id
    public long   driverId;
    public String firstName;

    public DriverInformation() {
    }

    public String lastName;
    public String licenseNumber;
    public String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getDriverId() {
        return driverId;
    }

    public DriverInformation(String firstName, String lastName, String licenseNumber, String mobileNumber, long driverId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
        this.mobileNumber = mobileNumber;
        this.driverId = driverId;

    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;

    }

    @Override
    public String toString() {
        return "DriverInformation{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", driverId=" + driverId +
                '}';
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
