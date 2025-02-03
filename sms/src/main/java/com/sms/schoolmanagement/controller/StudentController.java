package com.sms.schoolmanagement.controller;

import com.sms.schoolmanagement.model.Student;
import com.sms.schoolmanagement.service.CustomStudentService;
import com.sms.schoolmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:55524")
public class StudentController {

    private final StudentService studentService;
    private final CustomStudentService customStudentService;
    // private final AdmissionService admissionService;

    @Autowired
    public StudentController(StudentService studentService, CustomStudentService customStudentService) {
        this.studentService = studentService;
        this.customStudentService = customStudentService;
        // this.admissionService = admissionService;
        // ,AdmissionService admissionService
    }    

    // Student
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
    
    @GetMapping("/byFirstName/{firstName}")
    public List<Student> getStudentByFirstName(@PathVariable String firstName) {
        return studentService.getStudentByFirstName(firstName);
    }   
    
    @GetMapping("/count")
    public int countAllStudents() {
        return customStudentService.countAllStudents();
    }   
    
    /*
    // Admission
    @GetMapping("/admission")
    public List<Admission> getAllAdmissions() {
        return admissionService.getAllAdmission();
    }    
    
    @GetMapping("/admission/{admissionId}")
    public Admission getAdmissionById(@PathVariable Long admissionId) {
        return admissionService.getAdmissionById(admissionId);
    }   
    
    @GetMapping("/admission/studentId/{studentId}")
    public List<Admission> getAdmissionByStudentId(@PathVariable Long studentId) {
        return admissionService.getAdmissionByStudentId(studentId);
    }       
    
    @PostMapping("/admission")
    public Admission saveAdmission(@RequestBody Admission admission) {
        return admissionService.saveAdmission(admission);
    }
    
    @DeleteMapping("/admission/{admissionId}")
    public void deleteAdmission(@PathVariable Long admissionId) {
    	admissionService.deleteAdmission(admissionId);
    }   
    */
}
