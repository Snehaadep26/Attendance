package com.example.attendance.AttendanceApi;

import java.util.ArrayList;
import java.util.Date;

public class GetDashboardResponse {
    public boolean warning;
    public AttendanceToday attendanceToday;
    public String since;
    public AttendanceOverview attendanceOverview;
    public ArrayList<Object> upcomingLeaveOrRequest;
    public ArrayList<Holiday> holidays;
    public ArrayList<WeeklyAttendance> weeklyAttendance;
    public MonthlyAttendance monthlyAttendance;

    public GetDashboardResponse(boolean warning, AttendanceToday attendanceToday, String since, AttendanceOverview attendanceOverview, ArrayList<Object> upcomingLeaveOrRequest, ArrayList<Holiday> holidays, ArrayList<WeeklyAttendance> weeklyAttendance, MonthlyAttendance monthlyAttendance) {
        this.warning = warning;
        this.attendanceToday = attendanceToday;
        this.since = since;
        this.attendanceOverview = attendanceOverview;
        this.upcomingLeaveOrRequest = upcomingLeaveOrRequest;
        this.holidays = holidays;
        this.weeklyAttendance = weeklyAttendance;
        this.monthlyAttendance = monthlyAttendance;
    }

    public boolean isWarning() {
        return warning;
    }

    public AttendanceToday getAttendanceToday() {
        return attendanceToday;
    }

    public String getSince() {
        return since;
    }

    public AttendanceOverview getAttendanceOverview() {
        return attendanceOverview;
    }

    public ArrayList<Object> getUpcomingLeaveOrRequest() {
        return upcomingLeaveOrRequest;
    }

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public ArrayList<WeeklyAttendance> getWeeklyAttendance() {
        return weeklyAttendance;
    }

    public MonthlyAttendance getMonthlyAttendance() {
        return monthlyAttendance;
    }
}

