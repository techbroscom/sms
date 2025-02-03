package com.sms.schoolmanagement.service;

import com.sms.schoolmanagement.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    List<Student> getStudentByFirstName(String firstName);
    Student saveStudent(Student student);
    void deleteStudent(Long studentId);
}
