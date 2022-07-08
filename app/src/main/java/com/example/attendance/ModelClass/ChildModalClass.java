package com.example.attendance.ModelClass;

import java.util.Date;

public class ChildModalClass {
    String day,holidayInfo;
    Date date;

    public ChildModalClass(String day, String holidayInfo, Date date) {
        this.day = day;
        this.holidayInfo = holidayInfo;
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public String getHolidayInfo() {
        return holidayInfo;
    }

    public Date getDate() {
        return date;
    }
}
