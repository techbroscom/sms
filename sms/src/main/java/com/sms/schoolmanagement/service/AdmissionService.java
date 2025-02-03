package com.sms.schoolmanagement.service;

import com.sms.schoolmanagement.model.Admission;
import java.util.List;

public interface AdmissionService {
	// To list all the admission
	List<Admission> getAllAdmission();

	// To get the specific admission detail based on id
	Admission getAdmissionById(Long AdmissionId);

	// To get the specific admission detail based on student id
	List<Admission> getAdmissionByStudentId(Long StudentId);

	// To save the admission detail
	Admission saveAdmission(Admission admission);

	// To delete the admission detail
	void deleteAdmission(Long admissionId);
}
