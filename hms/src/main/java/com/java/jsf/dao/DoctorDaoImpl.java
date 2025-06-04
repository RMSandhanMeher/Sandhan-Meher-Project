package com.java.jsf.dao;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;

import com.java.jsf.model.Doctor;
import com.java.jsf.model.Specialization;
import com.java.jsf.util.SessionHelper;

public class DoctorDaoImpl implements DoctorDao{
	
	SessionFactory sf;
	Session ss;
	
	

	private String special;
	
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	@Override
	public String addDoctor(Doctor doctor) {
		SessionFactory sf = SessionHelper.getConnection();
		Session ss =  sf.openSession();
		Transaction tran = ss.beginTransaction();
		ss.save(doctor);
		tran.commit();
		return "Menu.jsp?faces-redirect=true";
	}
	@Override
	public List<Doctor> showDoctor() {
		SessionFactory sf = SessionHelper.getConnection();
		Session ss = sf.openSession();
		Criteria ct = ss.createCriteria(Doctor.class);
		List<Doctor> doclist = ct.list();
		return doclist;
	}
	@Override
	public List<Doctor> showbyCategory(Specialization s) {
		 SessionFactory sf = SessionHelper.getConnection();
		    Session session = sf.openSession();

		    Criteria criteria = session.createCriteria(Doctor.class);
		    criteria.add(Restrictions.eq("special", s)); // enum filtering

		    List<Doctor> doctorList = criteria.list();
		    session.close();

		    return doctorList;
		
	}
	
	public List<String> getSpecializations() {
	    SessionFactory sf = SessionHelper.getConnection();
	    Session session = sf.openSession();
	    Criteria cr = session.createCriteria(Doctor.class);
	    Projection projection = Projections.distinct(Projections.property("special")); 
	    cr.setProjection(projection); 
	    List<String> list = cr.list();
	    session.close();
	    return list;
	}
	
	public void doctorSpecializationChanged(ValueChangeEvent e) {
	    
	    this.special = e.getNewValue().toString();
	    System.out.println(this.special);
	}
	
	@Override
	public Doctor searchbyId(String id) {
		SessionFactory sf = SessionHelper.getConnection();
	    Session ss = sf.openSession();
	    Criteria ct = ss.createCriteria(Doctor.class);
	    ct.add(Restrictions.eq("doctorId", id));
	    Doctor dt = (Doctor) ct.uniqueResult();
	   
	    return dt;
	}
}
