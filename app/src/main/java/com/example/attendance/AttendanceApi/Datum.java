package com.example.attendance.AttendanceApi;

import java.util.Date;

public class Datum {
    public int id;
    public Date date;
    public String title;
    public Date createdAt;
    public Date updatedAt;

    public Datum(int id, Date date, String title, Date createdAt, Date updatedAt) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
