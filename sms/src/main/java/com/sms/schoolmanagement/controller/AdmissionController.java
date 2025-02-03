package com.sms.schoolmanagement.controller;

import com.sms.schoolmanagement.model.Admission;
import com.sms.schoolmanagement.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admission")
public class AdmissionController {

    private final AdmissionService admissionService;

    @Autowired
    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }    
    
    // Admission
    @GetMapping
    public List<Admission> getAllAdmissions() {
        return admissionService.getAllAdmission();
    }    
    
    @GetMapping("/{admissionId}")
    public Admission getAdmissionById(@PathVariable Long admissionId) {
        return admissionService.getAdmissionById(admissionId);
    }   
    
    @GetMapping("/studentId/{studentId}")
    public List<Admission> getAdmissionByStudentId(@PathVariable Long studentId) {
        return admissionService.getAdmissionByStudentId(studentId);
    }       
    
    @PostMapping
    public Admission saveAdmission(@RequestBody Admission admission) {
        return admissionService.saveAdmission(admission);
    }
    
    @DeleteMapping("/{admissionId}")
    public void deleteAdmission(@PathVariable Long admissionId) {
    	admissionService.deleteAdmission(admissionId);
    }     
}
