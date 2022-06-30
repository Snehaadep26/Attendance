package com.example.attendance.AttendanceApi;

public class MonthlyAttendance {
    public int totalWorkingDaysTillDate;
    public double presentDays;
    public double absentDays;
    public double averagePercentage;
    public String month;

    public MonthlyAttendance(int totalWorkingDaysTillDate, double presentDays, double absentDays, double averagePercentage, String month) {
        this.totalWorkingDaysTillDate = totalWorkingDaysTillDate;
        this.presentDays = presentDays;
        this.absentDays = absentDays;
        this.averagePercentage = averagePercentage;
        this.month = month;
    }

    public int getTotalWorkingDaysTillDate() {
        return totalWorkingDaysTillDate;
    }

    public double getPresentDays() {
        return presentDays;
    }

    public double getAbsentDays() {
        return absentDays;
    }

    public double getAveragePercentage() {
        return averagePercentage;
    }

    public String getMonth() {
        return month;
    }
}
