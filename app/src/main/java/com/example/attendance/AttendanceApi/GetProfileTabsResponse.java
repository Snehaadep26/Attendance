package com.example.attendance.AttendanceApi;

import java.util.ArrayList;

public class GetProfileTabsResponse {
    public LeaveTab leaveTab;
    public AttendanceTab attendanceTab;

    public GetProfileTabsResponse(LeaveTab leaveTab, AttendanceTab attendanceTab) {
        this.leaveTab = leaveTab;
        this.attendanceTab = attendanceTab;
    }

    public LeaveTab getLeaveTab() {
        return leaveTab;
    }

    public AttendanceTab getAttendanceTab() {
        return attendanceTab;
    }
}

