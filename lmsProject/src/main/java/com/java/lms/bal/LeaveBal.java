package com.java.lms.bal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.java.lms.dao.EmployDaoImpl;
import com.java.lms.dao.LeaveDaoImpl;
import com.java.lms.model.Leave;

public class LeaveBal {
	static EmployDaoImpl empDaoImp;
	static LeaveDaoImpl leaDaoImpl;
	static StringBuilder sb;
	
	static {
		empDaoImp=new EmployDaoImpl();
		leaDaoImpl=new LeaveDaoImpl();
		sb=new StringBuilder();
	}
	
	
	public String applyALeaveBal(Leave leave) throws ClassNotFoundException, SQLException {
			
		if(validateLeave(leave)) {
			empDaoImp.setEmployLeaveDayByIdDaoImpl(leave.getEmpId(),empDaoImp.getEmployLeaveById(leave.getEmpId())-leave.getNoOfDays());
			return  leaDaoImpl.applyALeaveDaoImpl(leave);
		}
		return sb.toString();
	}
	
	public List<Leave> allLeaveTakenByEmpBal(int empId) throws ClassNotFoundException, SQLException{
		return leaDaoImpl.readAllLeaveTakenDaoImpl(empId);
	}
	
	public List<Leave> showRequestedLeaves(int managerId) throws ClassNotFoundException, SQLException{
		return leaDaoImpl.showRequestedLeaveDaoImpl(managerId);
	}
	
	
	public static boolean validateLeave(Leave leave) throws ClassNotFoundException, SQLException {
		
		LocalDate lst=leave.getEndDate().toLocalDate();
		LocalDate std=leave.getStartDate().toLocalDate();
		leave.setNoOfDays((int)ChronoUnit.DAYS.between( std,lst));
		boolean verify=true;
		
		sb.setLength(0);
		if(lst.isBefore(LocalDate.now()) || std.isBefore(LocalDate.now())) {
			sb.append("start date should not be past ");
			verify=false;
		}
		if(lst.isBefore(LocalDate.now()) ) {
			sb.append("end date should not be past");
			verify=false;
		}
		if(lst.isBefore(std)) {
			sb.append("start date should not be greater than  end date ");
			verify=false;
		}
		if(leave.getNoOfDays()>=empDaoImp.getEmployLeaveById(leave.getEmpId())) {
			sb.append(" insufficient no of leave day");
			verify=false;
		}
		
		
		return verify;
	}
}
