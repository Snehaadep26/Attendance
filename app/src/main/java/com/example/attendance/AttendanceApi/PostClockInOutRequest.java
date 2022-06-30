package com.example.attendance.AttendanceApi;


public class PostClockInOutRequest {
    public String latitude;
    public String longitude;

    public PostClockInOutRequest(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}

