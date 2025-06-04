package com.java.lms.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.lms.model.Leave;
import com.java.lms.model.LeaveStatus;

public interface LeaveDao {
	
//	user methods
	public String applyALeaveDaoImpl(Leave leave) throws ClassNotFoundException, SQLException;
	public String readALeaveByIdDaoImpl(int leaveId);
	public List<Leave> readAllLeaveTakenDaoImpl(int employId) throws ClassNotFoundException, SQLException;
	public String updateALeaveDaoImpl(Leave leave);
	public String deleteALeaveDaoImpl(int leaveId);
	
//	all manager methods
	public List<Leave>  showRequestedLeaveDaoImpl(int empAsManagerId) throws ClassNotFoundException, SQLException;
	public String changeLeaveStatusDaoImple(int leaveId ,LeaveStatus leaveStatus, String managerComment) throws ClassNotFoundException, SQLException;	
	
}
