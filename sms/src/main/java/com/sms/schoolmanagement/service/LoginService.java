package com.sms.schoolmanagement.service;

import com.sms.schoolmanagement.model.LoginResponse;
import com.sms.schoolmanagement.model.Student;

public interface LoginService {
    LoginResponse login(String username, String password);
//    Student findByStudentId(String userId);
}	