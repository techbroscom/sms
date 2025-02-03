package com.sms.schoolmanagement.repository;

import com.sms.schoolmanagement.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String firstName);
}
