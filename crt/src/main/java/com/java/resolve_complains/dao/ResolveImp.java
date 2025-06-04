package com.java.resolve_complains.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.java.resolve_complains.model.Complaint;
import com.java.resolve_complains.model.Resolve;

public class ResolveImp implements ResolveDao{

	@Override
	public String resolve(Resolve resolve) throws Exception {
	    SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Complaint complaint = resolve.getComplaint();
	    if (complaint == null || complaint.getComplaintID() == null) {
	        session.close();
	        sf.close();
	        return "Complaint reference is missing in the Resolve object.";
	    }
	    Complaint dbComplaint = (Complaint) session.get(Complaint.class, complaint.getComplaintID());
	    if (dbComplaint == null) {
	        session.close();
	        sf.close();
	        return "Complaint ID not found in database.";
	    }
	    String lastResolveID = getLastResolveID(session);  
	    String newResolveID = incrementCode(lastResolveID); 
	    resolve.setResolveId(newResolveID);  
	    String resolveDate = resolve.getResolveDate(); 
	    if (resolveDate == null) {
	        session.close();
	        sf.close();
	        return "Resolve date must be set before calling this method.";
	    }

	    String resolveDate1 = resolve.getResolveDate();
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 java.util.Date resolveDateParsed = sdf.parse(resolveDate1);
	 long tat = (resolveDateParsed.getTime() - dbComplaint.getComplaintDate().getTime()) / (1000 * 60 * 60 * 24);
	 resolve.setTat(tat);
	    resolve.setComplaint(dbComplaint);
	    dbComplaint.setStatus("Resolved");
	    session.update(dbComplaint);
	    session.save(resolve);  
	    tx.commit();
	    session.close();
	    sf.close();

	    return "Complaint resolved with ID: " + newResolveID + " and TAT: " + tat + " day(s)";
	}
	private String getLastResolveID(Session session) {
	    Criteria crit = session.createCriteria(Resolve.class);
	    crit.setProjection(Projections.max("resolveId"));  
	    String lastResolveID = (String) crit.uniqueResult();  
	    if (lastResolveID == null) {
	        return "r000";  
	    }

	    return lastResolveID;
	}
	public static String incrementCode(String currentCode) {
	    String numberPart = currentCode.substring(1); 
	    int numericValue = Integer.parseInt(numberPart); 
	    numericValue++;
	    String incrementedNumber = String.format("%03d", numericValue); 
	    return "r" + incrementedNumber; 
	}



	@Override
	public List<Resolve> showResolves() {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Resolve.class);
		return c.list();
	}

	@Override
	public Resolve searchResolveByComplaintId(String complaintId) {
	    SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sf.openSession();

	    Criteria criteria = session.createCriteria(Resolve.class);
	    criteria.add(Restrictions.eq("complaint.complaintID", complaintId));  // Match complaintID instead of resolveID

	    Resolve resolve = (Resolve) criteria.uniqueResult();

	    session.close();
	    sf.close();

	    return resolve;
	}



	

}
