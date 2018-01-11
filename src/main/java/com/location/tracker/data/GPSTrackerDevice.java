package com.location.tracker.data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by santoshk on 1/9/18.
 */
@Document(collection="DeviceInformation")
public class GPSTrackerDevice {

    @Id
    Long deviceId;
    String productInformation ;
    Integer trackFrequency;
    String additionalInfo;


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



    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }




    public GPSTrackerDevice(String productInformation, Long deviceId, Integer trackFrequency) {
        this.productInformation = productInformation;
        this.deviceId = deviceId;
        this.trackFrequency = trackFrequency;
    }
}
