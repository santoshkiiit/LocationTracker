package com.location.tracker.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by santoshk on 1/11/18.
 */

@Document(collection="mobileAppInfo")
public class MobileAppInfo {

    @Id
    String mobileNumber;
    String name;
    String version;


    public MobileAppInfo() {
    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public MobileAppInfo(String mobileNumber, String version, String name) {
        this.mobileNumber = mobileNumber;
        this.version = version;
        this.name = name;
    }

    public void setMobileNumber(String mobileNumber) {

        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
