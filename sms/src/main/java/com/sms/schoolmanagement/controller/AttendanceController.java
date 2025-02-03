package com.sms.schoolmanagement.controller;

import com.sms.schoolmanagement.model.Attendance;
import com.sms.schoolmanagement.model.AttendanceRequest;
import com.sms.schoolmanagement.service.AttendanceService;
import com.sms.schoolmanagement.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<String> saveOrUpdateAttendance(@RequestBody AttendanceRequest attendanceRequest) {
        try {
            // Logic to save or update attendance based on studentId and date
            attendanceService.saveOrUpdateAttendance(attendanceRequest);
            return ResponseEntity.ok("Attendance saved or updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving or updating attendance");
        }
    }

    @GetMapping("/{studentId}/{date}")
    public ResponseEntity<Attendance> getAttendance(@PathVariable Long studentId, @PathVariable String date) {
        try {
            // Logic to retrieve attendance based on studentId and date
            Attendance attendance = attendanceService.getAttendance(studentId, LocalDate.parse(date));
            if (attendance != null) {
                return ResponseEntity.ok(attendance);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Other endpoints, if needed...

}

