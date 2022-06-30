package com.example.attendance.AttendanceApi;

public class Show {
    public String type;
    public String message;

    public Show(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
