package com.sms.schoolmanagement.repository;

import com.sms.schoolmanagement.model.Admission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {

	List<Admission> findByStudent_StudentId(Long studentId);
}
