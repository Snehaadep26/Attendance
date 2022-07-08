package com.example.attendance.AttendanceApi;


public class PostAttendanceRequest {
    public String requestType;
    public String startDate;
    public String clockIn;
    public String clockOut;
    public String reason;

    public PostAttendanceRequest(String requestType, String startDate, String clockIn, String clockOut, String reason) {
        this.requestType = requestType;
        this.startDate = startDate;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.reason = reason;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getClockIn() {
        return clockIn;
    }

    public String getClockOut() {
        return clockOut;
    }

    public String getReason() {
        return reason;
    }
}

