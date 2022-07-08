package com.example.attendance.AttendanceApi;

public class PostAttendanceResponse {
    public Show show;

    public PostAttendanceResponse(Show show) {
        this.show = show;
    }

    public Show getShow() {
        return show;
    }
}


