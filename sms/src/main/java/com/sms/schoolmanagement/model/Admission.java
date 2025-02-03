package com.sms.schoolmanagement.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Admission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long admissionId;

	@Column(nullable = false)
	private LocalDate admissionDate;

	private String course;

	private BigDecimal fees;

	// Many-to-one relationship with Student
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	// Enum for admission status
	public enum AdmissionStatus {
		PENDING, APPROVED, REJECTED
	}

	@Enumerated(EnumType.STRING)
	private AdmissionStatus admissionStatus;

	private String guardian_name;
	private Long guardian_contact;
	private String student_note;
	private String student_conduct;
	private BigDecimal dues;

	public Admission() {
		// Default constructor
	}

	public Admission(LocalDate admissionDate, String course, BigDecimal fees, Student student,
			AdmissionStatus admissionStatus, String guardianName, Long guardianContact, String studentNote,
			String studentConduct, BigDecimal dues) {
		this.admissionDate = admissionDate;
		this.course = course;
		this.fees = fees;
		this.student = student;
		this.admissionStatus = admissionStatus;
		this.guardian_name = guardianName;
		this.guardian_contact = guardianContact;
		this.student_note = studentNote;
		this.student_conduct = studentConduct;
		this.dues = dues;
	}

	public Long getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AdmissionStatus getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(AdmissionStatus admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public String getGuardian_name() {
		return guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	public Long getGuardian_contact() {
		return guardian_contact;
	}

	public void setGuardian_contact(Long guardian_contact) {
		this.guardian_contact = guardian_contact;
	}

	public String getStudent_note() {
		return student_note;
	}

	public void setStudent_note(String student_note) {
		this.student_note = student_note;
	}

	public String getStudent_conduct() {
		return student_conduct;
	}

	public void setStudent_conduct(String student_conduct) {
		this.student_conduct = student_conduct;
	}

	public BigDecimal getDues() {
		return dues;
	}

	public void setDues(BigDecimal dues) {
		this.dues = dues;
	}

	@Override
	public String toString() {
		return "Admission{" + "admissionId=" + admissionId + ", admissionDate=" + admissionDate + ", course='" + course
				+ '\'' + ", fees=" + fees + ", student=" + student + ", admissionStatus=" + admissionStatus
				+ ", guardianName=" + guardian_name + ", guardianContact=" + guardian_contact + ", studentNote="
				+ student_note + ", studentConduct = " + student_conduct + ", dues=" + dues + '}';
	}
}
