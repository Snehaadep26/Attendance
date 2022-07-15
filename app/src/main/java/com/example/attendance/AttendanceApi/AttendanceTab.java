package com.example.attendance.AttendanceApi;

import java.util.ArrayList;

public class AttendanceTab {
    public Overview overview;
    public String since;
    public AttendanceByTimesheet attendanceByTimesheet;
    public ArrayList<Object> attendanceHistory;

    public AttendanceTab(Overview overview, String since, AttendanceByTimesheet attendanceByTimesheet, ArrayList<Object> attendanceHistory) {
        this.overview = overview;
        this.since = since;
        this.attendanceByTimesheet = attendanceByTimesheet;
        this.attendanceHistory = attendanceHistory;
    }

    public Overview getOverview() {
        return overview;
    }

    public String getSince() {
        return since;
    }

    public AttendanceByTimesheet getAttendanceByTimesheet() {
        return attendanceByTimesheet;
    }

    public ArrayList<Object> getAttendanceHistory() {
        return attendanceHistory;
    }
}
