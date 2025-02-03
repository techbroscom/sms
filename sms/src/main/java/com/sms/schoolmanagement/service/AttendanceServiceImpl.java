package com.sms.schoolmanagement.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sms.schoolmanagement.model.Attendance;
import com.sms.schoolmanagement.model.AttendanceRequest;
import com.sms.schoolmanagement.model.Student;
import com.sms.schoolmanagement.repository.AttendanceRepository;
import com.sms.schoolmanagement.repository.StudentRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveOrUpdateAttendance(AttendanceRequest attendanceRequest) {
        // Retrieve the student by studentId
        Optional<Student> optionalStudent = studentRepository.findById(attendanceRequest.getStudentId());

        if (optionalStudent.isPresent()) {
            // Student exists, proceed with saving or updating attendance

            // Check if attendance record for the given date already exists
            Optional<Attendance> existingAttendance = attendanceRepository.findByStudentAndDate(
                    optionalStudent.get(),
                    attendanceRequest.getDate()
            );

            if (existingAttendance.isPresent()) {
                // Update existing attendance record
                Attendance attendanceToUpdate = existingAttendance.get();
                attendanceToUpdate.setStatus(attendanceRequest.getStatus());
                attendanceRepository.save(attendanceToUpdate);
            } else {
                // Create a new attendance record
                Attendance newAttendance = new Attendance();
                newAttendance.setStudent(optionalStudent.get());
                newAttendance.setDate(attendanceRequest.getDate());
                newAttendance.setStatus(attendanceRequest.getStatus());
                attendanceRepository.save(newAttendance);
            }
        } else {
            // Student not found, handle accordingly (throw exception, return error response, etc.)
            throw new EntityNotFoundException("Student not found with ID: " + attendanceRequest.getStudentId());
        }
    }

    @Override
    public Attendance getAttendance(Long studentId, LocalDate date) {
        // Retrieve the student by studentId
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            // Student exists, retrieve attendance record for the given date
            return attendanceRepository.findByStudentAndDate(optionalStudent.get(), date)
                    .orElse(null);
        } else {
            // Student not found, return null or handle accordingly
            throw new EntityNotFoundException("Student not found with ID: " + studentId);
        }
    }

	@Override
	public void deleteAttendance(Long attendanceId) {
		// TODO Auto-generated method stub
		
	}

}