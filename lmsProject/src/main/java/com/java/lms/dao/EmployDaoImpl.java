package com.java.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.lms.model.Employ;
import com.java.lms.util.ConnectionHealper;

public class EmployDaoImpl implements EmployDao {

	@Override
	public Employ searchEmployDaoImpl(int empId) throws ClassNotFoundException, SQLException {
		
		String cmd="select * from Employee where EMP_ID=?";
		
		Connection connection=ConnectionHealper.getConnection();
		PreparedStatement pst=connection.prepareStatement(cmd);
		 pst.setInt(1,empId);
		 ResultSet res= pst.executeQuery();
		 
		 Employ emp=null;
		 if(res.next()) {
			 emp=new Employ();
			 emp.setEmpAvailLeave(res.getInt("EMP_AVAIL_LEAVE_BAL"));
			 emp.setEmpDepartment(res.getString("EMP_DEPT"));
			 emp.setEmpEmail(res.getString("EMP_MAIL"));
			 emp.setEmpId(res.getInt("EMP_ID"));
			 emp.setEmpManagerId(res.getInt("EMP_MANAGER_ID"));
			 emp.setEmpMobileNumber(res.getString("EMP_MOB_NO"));
			 emp.setEmpName(res.getString("EMP_NAME"));
		 }
		return emp;
	}

	@Override
	public void showAllEmployDaoImpl() throws SQLException, ClassNotFoundException {

		String cmd="select * from Employee";
		
		Connection connection=ConnectionHealper.getConnection();
		PreparedStatement pst=connection.prepareStatement(cmd);
		 ResultSet res= pst.executeQuery();
		 
		 Employ emp=null;
		 while(res.next()) {
			 emp=new Employ();
			 emp.setEmpAvailLeave(res.getInt("EMP_AVAIL_LEAVE_BAL"));
			 emp.setEmpDepartment(res.getString("EMP_DEPT"));
			 emp.setEmpEmail(res.getString("EMP_MAIL"));
			 emp.setEmpId(res.getInt("EMP_ID"));
			 emp.setEmpManagerId(res.getInt("EMP_MANAGER_ID"));
			 emp.setEmpMobileNumber(res.getString("EMP_MOB_NO"));
			 emp.setEmpName(res.getString("EMP_NAME"));
			 System.out.print(emp);
			 System.out.println("\n---------------------------------------");
			 
		 }
		
	}

	@Override
	public int getEmployLeaveById(int empId) throws ClassNotFoundException, SQLException {
		String cmd="select EMP_AVAIL_LEAVE_BAL from EMPLOYEE where EMP_ID=?";
		
		Connection connection=ConnectionHealper.getConnection();
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setInt(1, empId);
		ResultSet res= pst.executeQuery();
		res.next();
		
		return res.getInt("EMP_AVAIL_LEAVE_BAL");
	}

	@Override
	public String setEmployLeaveDayByIdDaoImpl(int empId,int noOfLeaveDays) throws ClassNotFoundException, SQLException {
		String cmd="update EMPLOYEE  set EMP_AVAIL_LEAVE_BAL=? where EMP_ID=?";
		
		Connection connection=ConnectionHealper.getConnection();
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setInt(1, noOfLeaveDays);
		pst.setInt(2, empId);
		pst.executeUpdate();
		
		return " employ no of leave now updated";
		
	}

}
