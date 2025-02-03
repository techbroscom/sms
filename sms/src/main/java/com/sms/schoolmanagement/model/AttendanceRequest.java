package com.sms.schoolmanagement.model;

import java.time.LocalDate;

public class AttendanceRequest {

    private Long studentId;
    private LocalDate date;
    private String status;

    public AttendanceRequest() {
        // Default constructor
    }

    public AttendanceRequest(Long studentId, LocalDate date, String status) {
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
