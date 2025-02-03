package com.sms.schoolmanagement.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @Column(nullable = false)
    private LocalDate date;

    /*
    public enum AttendanceStatus {
        PRESENT,
        ABSENT,
        LEAVE,
        LATE
    }
    */

    // @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String status;

    // Many-to-one relationship with Student
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

	public Long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", date=" + date + ", status=" + status + ", student="
				+ student + "]";
	}
}
