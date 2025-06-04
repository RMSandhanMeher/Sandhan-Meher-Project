package com.java.jsf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.java.jsf.model.Patient;
import com.java.jsf.util.SessionHelper;

public class PatientDaoImpl implements PatientDao{
	
	SessionFactory sf;
	Session ss;
	@Override
	public String addPatient(Patient patient) {
		SessionFactory sf = SessionHelper.getConnection();
		Session ss = sf.openSession();
		Transaction tran = ss.beginTransaction();
		ss.save(patient);
		tran.commit();
		return "PatientMenu.jsp?faces-redirect=true";
	}
	
	@Override
	public Patient showPatient(String id) {
		SessionFactory sf = SessionHelper.getConnection();
		Session ss = sf.openSession();
		Criteria ct = ss.createCriteria(Patient.class);
		ct.add(Restrictions.eq("patientId", id));
		Patient patient = (Patient) ct.uniqueResult();
		return patient;
	}

	@Override
	public List<Patient> showPatientByDoctorId(String doctorId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session ss = sf.openSession();
		Criteria ct = ss.createCriteria(Patient.class);
		ct.createAlias("doctor", "d");  // Join the Patient and Doctor entities
        ct.add(Restrictions.eq("d.doctorId", doctorId));  // Filter by doctorId from Doctor
        
        List<Patient>patients = ct.list();
        return patients;
	}
	
}
