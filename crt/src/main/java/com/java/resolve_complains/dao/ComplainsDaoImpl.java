package com.java.resolve_complains.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.java.resolve_complains.model.Complaint;
import com.java.resolve_complains.model.Resolve;

public class ComplainsDaoImpl implements ComplainsDao
{

	@Override
	public String addComplaint(Complaint complain) throws Exception {
	    SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session s = sf.openSession();
	    Transaction trans = s.beginTransaction();
	    Criteria c = s.createCriteria(Complaint.class);
	    c.setProjection(Projections.max("complaintID")); 
	    String lastID = (String) c.uniqueResult();
	    if (lastID == null) {
	        lastID = "C000"; 
	    }
	    String nextID = incrementCode(lastID); 
	    complain.setComplaintID(nextID);
	    complain.setComplaintDate(new java.sql.Date(new java.util.Date().getTime()));
	    s.save(complain);
	    trans.commit();
	    s.close();
	    sf.close();

	    return "Complaint inserted with ID: " + nextID;
	}

	public static String incrementCode(String currentCode) {
	    String numberPart = currentCode.substring(1); // Remove the 'C'
	    int numericValue = Integer.parseInt(numberPart);
	    numericValue++;
	    String incremented = String.format("%03d", numericValue); // Pad with zeros
	    return "C" + incremented;
	}

	@Override
	public Complaint searchComplaint(String complaintId) throws Exception {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Complaint.class);
		cr.add(Restrictions.eq("complaintID", complaintId));
		Complaint c = (Complaint)cr.uniqueResult();
		if(c!=null)
		{
			return c;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Complaint> showAllComplaint() throws Exception {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Complaint.class);
		return c.list();
	}
	@Override
	public List<Complaint> showPendingComplains() {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Complaint.class);
		c.add(Restrictions.eq("status","pending"));
		List<Complaint> r=c.list();
		s.close();
		sf.close();
		return r;
	}
	
}