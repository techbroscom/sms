package com.sms.schoolmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sms.schoolmanagement.model.Admission;
import com.sms.schoolmanagement.repository.AdmissionRepository;

@Service
public class AdmissionServiceImpl implements AdmissionService {

	private final AdmissionRepository admissionRepository;

	@Autowired
	public AdmissionServiceImpl(AdmissionRepository admissionRepository) {
		this.admissionRepository = admissionRepository;
	}

	@Override
	public List<Admission> getAllAdmission() {
		return admissionRepository.findAll();
	}

	@Override
	public Admission getAdmissionById(Long admissionId) {
		return admissionRepository.findById(admissionId).orElse(null);
	}
	
	@Override
	public List<Admission> getAdmissionByStudentId(Long studentId) {
		return admissionRepository.findByStudent_StudentId(studentId);
	}	

	@Override
	public Admission saveAdmission(Admission admission) {
		return admissionRepository.save(admission);
	}

	@Override
	public void deleteAdmission(Long admissionId) {
		admissionRepository.deleteById(admissionId);
	}
}
