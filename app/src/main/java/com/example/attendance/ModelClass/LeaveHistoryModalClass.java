package com.example.attendance.ModelClass;

public class LeaveHistoryModalClass {
    String days_count_leave,leave_start_date,leave_end_date,leave_type;

    public LeaveHistoryModalClass(String days_count_leave, String leave_start_date, String leave_end_date, String leave_type) {
        this.days_count_leave = days_count_leave;
        this.leave_start_date = leave_start_date;
        this.leave_end_date = leave_end_date;
        this.leave_type = leave_type;
    }

    public String getDays_count_leave() {
        return days_count_leave;
    }

    public String getLeave_start_date() {
        return leave_start_date;
    }

    public String getLeave_end_date() {
        return leave_end_date;
    }

    public String getLeave_type() {
        return leave_type;
    }
}
