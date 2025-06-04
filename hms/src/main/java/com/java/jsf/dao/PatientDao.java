package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.Patient;

public interface PatientDao {
	String addPatient(Patient patient);
	Patient showPatient(String id);
	List<Patient> showPatientByDoctorId(String doctorId);
}
