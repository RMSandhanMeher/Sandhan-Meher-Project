package com.java.jsf.model;

import java.util.List;

public class Doctor {
	private String doctorId;
	private String doctorName;
	private Specialization special;
	private String location;
	private String mobileNo;
	private Status status;
	private List<Patient> patientList;
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Specialization getSpecial() {
		return special;
	}
	public void setSpecial(Specialization special) {
		this.special = special;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Patient> getPatientList() {
		return patientList;
	}
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", location=" + location + ", mobileNo="
				+ mobileNo + "]";
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String doctorId, String doctorName, Specialization special, String location, String mobileNo,
			Status status, List<Patient> patientList) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.special = special;
		this.location = location;
		this.mobileNo = mobileNo;
		this.status = status;
		this.patientList = patientList;
	}
	
}
