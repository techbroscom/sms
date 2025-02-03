package com.sms.schoolmanagement.service;

import com.sms.schoolmanagement.model.Attendance;
import com.sms.schoolmanagement.model.AttendanceRequest;

import java.time.LocalDate;

public interface AttendanceService {
	// To list all the attendance
	// List<Attendance> getAllAttendance();

	// To get the specific attendance detail based on id
	// Attendance getAttendanceById(Long AttendanceId);

	// To get the specific attendance detail based on student id
	Attendance getAttendance(Long studentId, LocalDate parse);

	// To save the attendance detail
	void saveOrUpdateAttendance(AttendanceRequest attendance);

	// To delete the attendance detail
	void deleteAttendance(Long attendanceId);

	
}
