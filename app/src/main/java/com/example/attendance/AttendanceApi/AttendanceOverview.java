package com.example.attendance.AttendanceApi;


public class AttendanceOverview {
    // @JsonProperty("PresentCount")
    public double presentCount;
    // @JsonProperty("AbsentCount")
    public double absentCount;
    public double overallPercentage;
    public String totalWorkingHoursTillDate;
    public String averageWorkingHoursTillDate;
    public String totalLeaves;

    public AttendanceOverview(double presentCount, double absentCount, double overallPercentage, String totalWorkingHoursTillDate, String averageWorkingHoursTillDate, String totalLeaves) {
        this.presentCount = presentCount;
        this.absentCount = absentCount;
        this.overallPercentage = overallPercentage;
        this.totalWorkingHoursTillDate = totalWorkingHoursTillDate;
        this.averageWorkingHoursTillDate = averageWorkingHoursTillDate;
        this.totalLeaves = totalLeaves;
    }

    public double getPresentCount() {
        return presentCount;
    }

    public double getAbsentCount() {
        return absentCount;
    }

    public double getOverallPercentage() {
        return overallPercentage;
    }

    public String getTotalWorkingHoursTillDate() {
        return totalWorkingHoursTillDate;
    }

    public String getAverageWorkingHoursTillDate() {
        return averageWorkingHoursTillDate;
    }

    public String getTotalLeaves() {
        return totalLeaves;
    }
}
