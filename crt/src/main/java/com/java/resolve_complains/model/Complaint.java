package com.java.resolve_complains.model;

import java.sql.Date;

public class Complaint {
//	ComplaintID varchar(30) primary key,
//	   ComplaintType varchar(30),
//	   CDescription varchar(100),
//	   ComplaintDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//	   Severity varchar(20),
//	   Status varchar(30) default 'Pending'
	String complaintID;
	String complaintType;
	String cDescription;
	Date complaintDate;
	String severity;
	String status="pending";
	public String getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(String complaintId) {
		this.complaintID = complaintId;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	public Date getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(Date complainDate) {
		this.complaintDate = complainDate;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Complaint(String complaintId, String complaintType, String cDescription, Date complainDate, String severity,
			String status) {
		super();
		this.complaintID = complaintId;
		this.complaintType = complaintType;
		this.cDescription = cDescription;
		this.complaintDate = complainDate;
		this.severity = severity;
		this.status = status;
	}
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintID + ", complaintType=" + complaintType + ", cDescription="
				+ cDescription + ", complainDate=" + complaintDate + ", severity=" + severity + ", status=" + status
				+ "]";
	}
	
}
