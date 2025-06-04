package com.java.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.java.lms.model.Leave;
import com.java.lms.model.LeaveStatus;
import com.java.lms.model.LeaveType;
import com.java.lms.util.ConnectionHealper;

public class LeaveDaoImpl implements LeaveDao{
	
	public static int generateLeaveId() throws ClassNotFoundException, SQLException {
		String cmd="select case when max(LEAVE_ID) is  null then  1 else max(LEAVE_ID)+1 end leaveId  from LEAVE_HISTORY";
		
		Connection connection=ConnectionHealper.getConnection();
		PreparedStatement pst=connection.prepareStatement(cmd);
		ResultSet res=pst.executeQuery();
		res.next();
		return res.getInt("leaveId");
	}

	@Override
	public String applyALeaveDaoImpl(Leave leave) throws ClassNotFoundException, SQLException {
		
		String cmd="insert into LEAVE_HISTORY (LEAVE_ID,LEAVE_NO_OF_DAYS,EMP_ID,LEAVE_START_DATE,LEAVE_END_DATE,LEAVE_TYPE,LEAVE_REASON) values(?,?,?,?,?,?,?)";
		
		Connection connection=ConnectionHealper.getConnection();
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setInt(1,generateLeaveId());
		pst.setInt(2, leave.getNoOfDays());
		pst.setInt(3,leave.getEmpId());
		pst.setDate(4, leave.getStartDate());
		pst.setDate(5, leave.getEndDate());
		pst.setString(6, leave.getLeaveType().name());
		pst.setString(7, leave.getLeaveReason());
	
		pst.executeUpdate();
		return " leave applied successfully";
	}

	@Override
	public String readALeaveByIdDaoImpl(int leaveId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public List<Leave> readAllLeaveTakenDaoImpl(int employId) throws ClassNotFoundException, SQLException {
        String cmd = "select * from leave_history where EMP_ID=?";
        Connection connection = ConnectionHealper.getConnection();
        PreparedStatement pst = connection.prepareStatement(cmd);
        pst.setInt(1, employId);
        ResultSet res = pst.executeQuery();
        List<Leave> leaves = new ArrayList<>();
        while (res.next()) {
            Leave leave = new Leave();
            leave.setLeaveId(res.getInt("LEAVE_ID"));
            leave.setNoOfDays(res.getInt("LEAVE_NO_OF_DAYS"));
            leave.setEmpId(res.getInt("EMP_ID"));
            leave.setStartDate(res.getDate("LEAVE_START_DATE"));
            leave.setEndDate(res.getDate("LEAVE_END_DATE"));
            leave.setLeaveReason(res.getString("LEAVE_REASON"));
            leave.setLeaveType(LeaveType.valueOf(res.getString("LEAVE_TYPE")));
            leave.setLeaveStatus(LeaveStatus.valueOf(res.getString("LEAVE_STATUS")));
            leaves.add(leave);
        }
        return leaves;
    }

	@Override
	public String updateALeaveDaoImpl(Leave leave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteALeaveDaoImpl(int leaveId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leave> showRequestedLeaveDaoImpl(int empAsManagerId) throws ClassNotFoundException, SQLException {
		String cmd="select * from EMPLOYEE e inner join LEAVE_HISTORY a on e.EMP_ID=a.EMP_ID where e.EMP_MANAGER_ID=? and a.LEAVE_STATUS='PENDING'";
		Connection connection= ConnectionHealper.getConnection();
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setInt(1, empAsManagerId);
		ResultSet res=pst.executeQuery();
		List<Leave> requestedLeaves = new ArrayList<>();
        while (res.next()) {
            Leave leave = new Leave();
            leave.setLeaveId(res.getInt("LEAVE_ID"));
            leave.setNoOfDays(res.getInt("LEAVE_NO_OF_DAYS"));
            leave.setEmpId(res.getInt("EMP_ID"));
            leave.setStartDate(res.getDate("LEAVE_START_DATE"));
            leave.setEndDate(res.getDate("LEAVE_END_DATE"));
            leave.setLeaveType(LeaveType.valueOf(res.getString("LEAVE_TYPE")));
            leave.setLeaveStatus(LeaveStatus.valueOf(res.getString("LEAVE_STATUS")));
            leave.setLeaveReason(res.getString("LEAVE_REASON"));
            requestedLeaves.add(leave);
        }
        return requestedLeaves;
	}

	@Override
	public String changeLeaveStatusDaoImple(int leaveId ,LeaveStatus leaveStatus, String managerComment) throws ClassNotFoundException, SQLException{
		String cmd="update leave_history set LEAVE_STATUS =? , LEAVE_MNGR_COMMENTS=? where LEAVE_ID=?";
		Connection connection =ConnectionHealper.getConnection();
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setString(1, leaveStatus.name());
		pst.setString(2, managerComment);
		pst.setInt(3, leaveId);
		pst.executeUpdate();
		return "leaveId "+leaveId +" get Updated to "+ leaveStatus.name();
	}

}
