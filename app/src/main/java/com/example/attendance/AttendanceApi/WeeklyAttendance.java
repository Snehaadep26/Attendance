package com.example.attendance.AttendanceApi;

public class WeeklyAttendance {
    public String unit;
    public double workingHrs;
    public int durationInMinutes;
    public String workingHours;
    public double percentageThanPrevDay;

    public WeeklyAttendance(String unit, double workingHrs, int durationInMinutes, String workingHours, double percentageThanPrevDay) {
        this.unit = unit;
        this.workingHrs = workingHrs;
        this.durationInMinutes = durationInMinutes;
        this.workingHours = workingHours;
        this.percentageThanPrevDay = percentageThanPrevDay;
    }

    public String getUnit() {
        return unit;
    }

    public double getWorkingHrs() {
        return workingHrs;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public double getPercentageThanPrevDay() {
        return percentageThanPrevDay;
    }
}
