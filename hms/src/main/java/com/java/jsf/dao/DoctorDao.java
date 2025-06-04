package com.java.jsf.dao;

import java.util.List;

import com.java.jsf.model.Doctor;
import com.java.jsf.model.Specialization;

public interface DoctorDao {
	String addDoctor(Doctor doctor);
	List<Doctor> showDoctor();
	List<Doctor> showbyCategory(Specialization s);
	Doctor searchbyId(String id);
	List<String> getSpecializations();
	
	
}
