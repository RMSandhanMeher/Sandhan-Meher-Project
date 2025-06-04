package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.MedicationHistory;

public interface MedicationHistoryDao {
	
	String addMedicalHistory(MedicationHistory medicationHistory);
	List<MedicationHistory> showPatientMedicalHistory(String patientId);
	List<MedicationHistory> showPatientTests(String patientId);
}
