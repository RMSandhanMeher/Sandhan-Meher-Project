package com.java.jsf.model;

import java.sql.Date;
import java.util.List;

public class Patient {
	private String patientId;
	private String patientName;
	private Doctor doctor ;
	private Date DOB;
	private List<MedicationHistory> medicalrecord;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public List<MedicationHistory> getMedicalrecord() {
		return medicalrecord;
	}
	public void setMedicalrecord(List<MedicationHistory> medicalrecord) {
		this.medicalrecord = medicalrecord;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", DOB="
				+ DOB + "]";
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String patientId, String patientName, Doctor doctor, Date dob,
	        List<MedicationHistory> medicalrecord) {
	    this.patientId = patientId;
	    this.patientName = patientName;
	    this.doctor = doctor;
	    this.DOB = dob;
	    this.medicalrecord = medicalrecord;
	}

	
	
	
}
