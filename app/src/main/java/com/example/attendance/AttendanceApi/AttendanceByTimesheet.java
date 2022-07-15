package com.example.attendance.AttendanceApi;

import java.util.ArrayList;


public class AttendanceByTimesheet {
    public int totalWorkingDaysTillDate;
    public int presentDays;
    public int absentDays;
    public String totalWorkingHoursTillDate;
    public String averageWorkingHoursTillDate;
    public ArrayList<AttendanceDetail> attendanceDetails;

    public AttendanceByTimesheet(int totalWorkingDaysTillDate, int presentDays, int absentDays, String totalWorkingHoursTillDate, String averageWorkingHoursTillDate, ArrayList<AttendanceDetail> attendanceDetails) {
        this.totalWorkingDaysTillDate = totalWorkingDaysTillDate;
        this.presentDays = presentDays;
        this.absentDays = absentDays;
        this.totalWorkingHoursTillDate = totalWorkingHoursTillDate;
        this.averageWorkingHoursTillDate = averageWorkingHoursTillDate;
        this.attendanceDetails = attendanceDetails;
    }

    public int getTotalWorkingDaysTillDate() {
        return totalWorkingDaysTillDate;
    }

    public int getPresentDays() {
        return presentDays;
    }

    public int getAbsentDays() {
        return absentDays;
    }

    public String getTotalWorkingHoursTillDate() {
        return totalWorkingHoursTillDate;
    }

    public String getAverageWorkingHoursTillDate() {
        return averageWorkingHoursTillDate;
    }

    public ArrayList<AttendanceDetail> getAttendanceDetails() {
        return attendanceDetails;
    }
}
