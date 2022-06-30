package com.example.attendance.AttendanceApi;

import java.util.ArrayList;

public class Holiday {
    public String month;
    public ArrayList<Datum> data;

    public Holiday(String month, ArrayList<Datum> data) {
        this.month = month;
        this.data = data;
    }

    public String getMonth() {
        return month;
    }

    public ArrayList<Datum> getData() {
        return data;
    }
}
