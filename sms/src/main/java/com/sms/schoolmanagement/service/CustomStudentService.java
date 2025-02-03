package com.sms.schoolmanagement.service;

import com.sms.schoolmanagement.repository.CustomStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomStudentService {

    private final CustomStudentRepository customStudentRepository;

    @Autowired
    public CustomStudentService(CustomStudentRepository customStudentRepository) {
        this.customStudentRepository = customStudentRepository;
    }

    public int countAllStudents() {
        return customStudentRepository.countAllStudents();
    }
}