package com.sms.schoolmanagement.repository;

import com.sms.schoolmanagement.model.Attendance;
import com.sms.schoolmanagement.model.AttendanceRequest;
import com.sms.schoolmanagement.model.Student;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	// List<Attendance> findByStudent_StudentId(Long studentId);
	// AttendanceRequest findByStudentAndDate(Long studentId, LocalDate parse);

	Optional<Attendance> findByStudentAndDate(Student student, LocalDate date);
}
