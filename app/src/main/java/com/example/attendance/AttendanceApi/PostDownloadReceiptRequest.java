package com.example.attendance.AttendanceApi;


public class PostDownloadReceiptRequest {
    public int userId;
    public String filter;
    public String startDate;
    public String endDate;

    public PostDownloadReceiptRequest(int userId, String filter, String startDate, String endDate) {
        this.userId = userId;
        this.filter = filter;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getUserId() {
        return userId;
    }

    public String getFilter() {
        return filter;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}


