package com.java.resolve_complains.model;

import java.sql.Date;

public class Resolve {
    
    // Fields
    String resolveId;
    String complaintID; 
    public String getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(String complaintId) {
		this.complaintID = complaintId;
	}

	private Complaint complaint;
    String resolveDate;
    String resolvedBy;
    String comments;
    long tat;
    
    // Add the missing complaintDate field
    private Date complaintDate;

    // Constructors
    public Resolve() {
        super();
    }

    

    public Resolve(String resolveId, String complaintId, Complaint complaint, String resolveDate, String resolvedBy,
			String comments, long tat, Date complaintDate) {
		super();
		this.resolveId = resolveId;
		this.complaintID = complaintId;
		this.complaint = complaint;
		this.resolveDate = resolveDate;
		this.resolvedBy = resolvedBy;
		this.comments = comments;
		this.tat = tat;
		this.complaintDate = complaintDate;
	}

	@Override
    public String toString() {
        return "Resolve [resolveId=" + resolveId + ", complaint=" + complaint + ", resolveDate=" + resolveDate
                + ", resolvedBy=" + resolvedBy + ", comments=" + comments + ", tat=" + tat + ", complaintDate=" + complaintDate + "]";
    }

    // Getters and setters
    public String getResolveId() {
        return resolveId;
    }

    public void setResolveId(String resolveId) {
        this.resolveId = resolveId;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaintId) {
        this.complaint = complaintId;
    }

    public String getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(String resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public long getTat() {
        return tat;
    }

    public void setTat(long tat) {
        this.tat = tat;
    }

    // Add the getter and setter for complaintDate
    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }
}
