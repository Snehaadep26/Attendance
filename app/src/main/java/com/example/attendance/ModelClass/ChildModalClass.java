package com.example.attendance.ModelClass;

public class ChildModalClass {
    String day,date,holidayInfo;

    public ChildModalClass(String day, String date, String holidayInfo) {
        this.day = day;
        this.date = date;
        this.holidayInfo = holidayInfo;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public String getHolidayInfo() {
        return holidayInfo;
    }
}
