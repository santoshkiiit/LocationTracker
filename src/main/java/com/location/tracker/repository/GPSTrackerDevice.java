package com.location.tracker.repository;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by santoshk on 1/9/18.
 */
@Document(collection="gpsDevice")
public class GPSTrackerDevice {
    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getTrackFrequency() {
        return trackFrequency;
    }

    public GPSTrackerDevice() {
    }

    public void setTrackFrequency(Integer trackFrequency) {
        this.trackFrequency = trackFrequency;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    Long deviceId;
    String productInformation ;
    Integer trackFrequency;

    public GPSTrackerDevice(String productInformation, Long deviceId, Integer trackFrequency) {
        this.productInformation = productInformation;
        this.deviceId = deviceId;
        this.trackFrequency = trackFrequency;
    }
}
