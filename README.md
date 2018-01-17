Location Tracker
A rest-based Location tracking service


Setup Instructions

Implemented using 

Java 1.8
Spring boot 1.5.9
Mongo - 3.6.1



Project startup steps Application:

import project as maven  Project.

mvn clean install
will build locTracker-0.0.1-SNAPSHOT.jar 

java -jar    locTracker-0.0.1-SNAPSHOT.jar  from terminal or Run LocationTrackerApplocation from IDE.









Implemented the following rest calls


1. Add driver information

URL: /location/tracker/addDriver
Request Type: PUT
Request Params: JSON Object for DriverInformation
sample Request:


{
	"driverId":61253623,
	"firstName":"Adam",
	"lastName":"v",
	"mobileNumber":"672153651236-6345",
	"licenseNumber":"sgdsf-5343"
}


2. Add vehicle information

URL: /location/tracker/addVehicle
Request Type: PUT
Request Params: JSON Object for VehicleInformation
sample Request:

{
	"regNumber":"UN54 BT123",
	"trackingDeviceId":12344,
	"capacity":5,
	"mobileNumber":"37625471"
	
}

3. Update GPS tracker device for vehicle, in case device has been updated in a vehicle.

URL:   /location/tracker/updateVehicleDevice


Request Type: POST

Request Params: regNumber and deviceId

regNumber:”UN12SA123”,  deviceId:125634


4. Insert trace point for vehicle (this call will be made by GPS device/mobile to update the location and other metrics, depending on type of device(mobile/gps) the request will send mobileNumber/deviceId)

Request Type: PUT

Request Params : JSON object for LocationTrace
URL:  /location/tracker/insertTracePoint 

Sample Request:
{
"driverId":	12345,
"mobileNumber":"2378-473473",
"latitude":354.6,
"longitude":73.5,
"locationName":"Test",
"speed":100,
"deviceType":"MOBILE",
"additionalInfo":"numberOfPassengers:3",
"regNumber":"GN527AH873"
}



 5 . Get Vehicle Location log  — based on deviceId/mobile number, fetch location trace points in specified time 
Request Type:GET

URL:  /location/tracker/getLog

Request Params: deviceId/mobileNumber ,fromTime , toTime


Sample Request:

deviceId:6325463, fromTime:2018/01/10 19:35:03, toTime :2018/01/10 19:39:05
mobileNumber=1256326, fromTime=2017/01/17 16:52:19, toTime=2018/01/17 18:52:19










￼



	


￼


