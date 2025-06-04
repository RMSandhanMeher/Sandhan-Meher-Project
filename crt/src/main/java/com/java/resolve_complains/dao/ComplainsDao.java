package com.java.resolve_complains.dao;

import java.util.List;

import com.java.resolve_complains.model.Complaint;
import com.java.resolve_complains.model.Resolve;

public interface ComplainsDao {
	//AddComplaint, SearchComplaint, ShowAllComplaint
	public String addComplaint(Complaint complain) throws Exception;
	public Complaint searchComplaint(String complaintId) throws Exception;
	public List<Complaint> showAllComplaint() throws Exception;
	public List<Complaint> showPendingComplains();
}
