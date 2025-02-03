package com.sms.schoolmanagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.schoolmanagement.model.Login;
import com.sms.schoolmanagement.model.LoginResponse;
import com.sms.schoolmanagement.model.Student;
import com.sms.schoolmanagement.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public LoginResponse login(String username, String password) {
        Login login = loginRepository.findByUsername(username);
    	LoginResponse response = new LoginResponse();
        if (login != null && login.getPassword().equals(password)) {
        	response.setSuccess(true);
        	response.setMessage("Authentication Success");
            return response;
        } else {
        	response.setSuccess(false);
        	response.setMessage("Authentication Failed");
            return response;
        }
    }
    
//    public Student findByStudentId(String id) {
//    	Student student = loginRepository.findByStudentId(id);
//		return student;
//    }
}
