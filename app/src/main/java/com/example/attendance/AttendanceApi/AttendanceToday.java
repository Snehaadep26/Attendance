package com.example.attendance.AttendanceApi;

public class AttendanceToday {
    public String startTime;
    public String endTime;
    public int duration;
    public int geoFenceId;
    public String geoFenceTitle;

    public AttendanceToday(String startTime, String endTime, int duration, int geoFenceId, String geoFenceTitle) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.geoFenceId = geoFenceId;
        this.geoFenceTitle = geoFenceTitle;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getGeoFenceId() {
        return geoFenceId;
    }

    public String getGeoFenceTitle() {
        return geoFenceTitle;
    }
}
