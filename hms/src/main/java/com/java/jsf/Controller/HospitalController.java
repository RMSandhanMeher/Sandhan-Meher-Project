package com.java.jsf.Controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.java.jsf.dao.*;
import com.java.jsf.model.*;

public class HospitalController {
	// DAO Objects
	private DoctorDao doctorDao;
	private PatientDao patientDao;
	private MedicationHistoryDao medicationHistoryDao;

	// Model Objects
	private Doctor doctor;
	private Patient patient;
	private MedicationHistory medicationHistory;

	// For Search ID
	private String searchId;
	private String special;
	private String patientId;
	private String doctorId;
	private List<Patient> patientList;
	private List<MedicationHistory> patientMedicalHistory;
	
	public List<MedicationHistory> getPatientMedicalHistory() {
		return patientMedicalHistory;
	}

	public void setPatientMedicalHistory(List<MedicationHistory> patientMedicalHistory) {
		this.patientMedicalHistory = patientMedicalHistory;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	// Getter and Setter for searchId
	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	// Getters and Setters for DAOs
	public DoctorDao getDoctorDao() {
		return doctorDao;
	}

	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	public PatientDao getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	public MedicationHistoryDao getMedicationHistoryDao() {
		return medicationHistoryDao;
	}

	public void setMedicationHistoryDao(MedicationHistoryDao medicationHistoryDao) {
		this.medicationHistoryDao = medicationHistoryDao;
	}

	// Getters and Setters for Models
	public Doctor getDoctor() {
		if (doctor == null) {
			doctor = new Doctor();
		}
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		if (patient == null) {
			patient = new Patient();
		}
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public MedicationHistory getMedicationHistory() {
		if (medicationHistory == null) {
			medicationHistory = new MedicationHistory();
		}
		return medicationHistory;
	}

	public void setMedicationHistory(MedicationHistory medicationHistory) {
		this.medicationHistory = medicationHistory;
	}

	// Doctor Operations
	public String addDoctor(Doctor doctor) {
		return doctorDao.addDoctor(doctor);
	}

	public List<Doctor> showAllDoctors() {
		return doctorDao.showDoctor();
	}

	public List<Doctor> showDoctorsByCategory(Specialization special) {
		return doctorDao.showbyCategory(special);
	}

	public List<String> getSpecializations() {
		return doctorDao.getSpecializations(); // Call the DAO to fetch specializations
	}

	public String searchDoctorById() {
		Doctor dt = doctorDao.searchbyId(searchId);
		if (dt == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Doctor not found!", null));
			return null;
		} else {
			this.doctor = dt;
			return null; // Stay on the same page
		}
	}

	// Patient Operations
	public String addPatient(Patient patient) {
		doctor = doctorDao.searchbyId(doctorId);
		patient.setDoctor(doctor);
		return patientDao.addPatient(patient);
	}

	public String showPatient() {
		Patient result = patientDao.showPatient(patientId); // Use DAO to fetch

		if (result != null) {
			this.patient = result; // Set controller's patient model
			return null; // Stay on current page
		} else {
			this.patient =null;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Patient not found!", null));
			return null; // Stay on current page
		}
	}

	public String showPatientsByDoctorId() {
	    // Fetch patients by doctorId
	    patientList = patientDao.showPatientByDoctorId(this.doctorId);
	    
	    // If no patients are found, display an error message
	    if (patientList == null || patientList.isEmpty()) {
	        FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, "No patients found for this Doctor.", null));
	    }
	    
	    return null; // Return the list of patients
	}


	// Medication History Operations
	public String addMedicalHistory() {
		return medicationHistoryDao.addMedicalHistory(medicationHistory);
	}

	public List<MedicationHistory> showPatientMedicalHistory() {
		this.patientMedicalHistory = medicationHistoryDao.showPatientMedicalHistory(this.patientId);
		if (this.patientMedicalHistory == null || this.patientMedicalHistory.isEmpty()) {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "No medical history found for Patient ID: " + this.patientId, null));
	    }

	    return null;
	}

	public List<MedicationHistory> showPatientTests() {
		this.patientMedicalHistory = medicationHistoryDao.showPatientMedicalHistory(this.patientId);
		if (this.patientMedicalHistory == null || this.patientMedicalHistory.isEmpty()) {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "No medical history found for Patient ID: " + this.patientId, null));
	    }

	    return null;
	}
}
