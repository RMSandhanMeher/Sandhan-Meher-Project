package com.java.lms.dao;

import java.sql.SQLException;

import com.java.lms.model.Employ;

public interface EmployDao {
	
	public Employ searchEmployDaoImpl(int empId) throws ClassNotFoundException, SQLException;
	public void showAllEmployDaoImpl() throws SQLException, ClassNotFoundException;
	public int getEmployLeaveById(int empId) throws ClassNotFoundException, SQLException;
	public String setEmployLeaveDayByIdDaoImpl(int empId,int noOfLeaveDays) throws ClassNotFoundException, SQLException;
	
}
