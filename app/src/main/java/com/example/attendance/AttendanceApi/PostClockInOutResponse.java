package com.example.attendance.AttendanceApi;


public class PostClockInOutResponse {
    public Show show;

    public PostClockInOutResponse(Show show) {
        this.show = show;
    }

    public Show getShow() {
        return show;
    }
}

