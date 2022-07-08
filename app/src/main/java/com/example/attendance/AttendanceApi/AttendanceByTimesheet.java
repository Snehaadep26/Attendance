package com.example.attendance.AttendanceApi;

import java.util.ArrayList;


public class AttendanceByTimesheet {
    public int totalWorkingDaysTillDate;
    public int presentDays;
    public int absentDays;
    public String totalWorkingHoursTillDate;
    public String averageWorkingHoursTillDate;
    public ArrayList<AttendanceDetail> attendanceDetails;
}
