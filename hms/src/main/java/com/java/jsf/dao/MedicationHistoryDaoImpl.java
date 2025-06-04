package com.java.jsf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.java.jsf.model.MedicationHistory;
import com.java.jsf.util.SessionHelper;

public class MedicationHistoryDaoImpl implements MedicationHistoryDao {
	 SessionFactory sf;
	 Session ss;
	@Override
	public String addMedicalHistory(MedicationHistory medicationHistory) {
		SessionFactory sf = SessionHelper.getConnection();
		Session ss = sf.openSession();
		Transaction tran = ss.beginTransaction();
		ss.save(medicationHistory);
		tran.commit();
		return "Menu.jsp?faces-redirect=true";
		
	}
	@Override
	public List<MedicationHistory> showPatientMedicalHistory(String patientId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session ss = sf.openSession();
		Criteria ct = ss.createCriteria(MedicationHistory.class);
		 ct.add(Restrictions.eq("patient.patientId", patientId));
		 List<MedicationHistory> medicalHistory = ct.list();
         return medicalHistory; 
	}
	@Override
	public List<MedicationHistory> showPatientTests(String patientId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session ss = sf.openSession();
		Criteria ct = ss.createCriteria(MedicationHistory.class);
		ct.add(Restrictions.eq("patient.patientId", patientId));
		List<MedicationHistory> tests = ct.list();
        return tests; 
	}
	 
}
