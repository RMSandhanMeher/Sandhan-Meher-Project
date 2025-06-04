package com.java.jsf.model;

public class MedicationHistory {
	private String medId;
	private Patient patient;
	private String medicine;
	private String tests;
	public String getMedId() {
		return medId;
	}
	public void setMedId(String medId) {
		this.medId = medId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getTests() {
		return tests;
	}
	public void setTests(String tests) {
		this.tests = tests;
	}
	@Override
	public String toString() {
		return "MedicationHistory [medId=" + medId + ", patient=" + patient + ", medicine=" + medicine + ", tests="
				+ tests + "]";
	}
	public MedicationHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicationHistory(String medId, Patient patient, String medicine, String tests) {
		super();
		this.medId = medId;
		this.patient = patient;
		this.medicine = medicine;
		this.tests = tests;
	}
	
	
}
