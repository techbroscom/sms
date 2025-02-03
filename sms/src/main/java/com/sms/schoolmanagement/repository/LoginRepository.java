
package com.sms.schoolmanagement.repository;

import com.sms.schoolmanagement.model.Login;
import com.sms.schoolmanagement.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Login findByUsername(String username);
    
}
