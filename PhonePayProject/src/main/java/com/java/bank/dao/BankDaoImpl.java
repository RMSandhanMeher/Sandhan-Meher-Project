package com.java.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.bank.model.Accounts;
import com.java.bank.util.ConnectionHelper;

public class BankDaoImpl implements BankDao {
	
	public boolean creditMoneyToBankDao(String mobileNumber,int amount) throws ClassNotFoundException, SQLException {
		
		Accounts account=searchAccountBankDao(mobileNumber);
		if(account.getAmount()-amount<0) {
			return false;
		}
		else {
			Connection connection=ConnectionHelper.getConnection();
			String setNewBalance="update Accounts set amount=? where MobileNo=?";
			PreparedStatement pst2=connection.prepareStatement(setNewBalance);
			pst2.setDouble(1,account.getAmount()+ amount);
			pst2.setString(2,mobileNumber);
			pst2.executeUpdate();
			return true;
		}
	}
	public boolean debitMoneyToBankDao(String mobileNumber,int amount) throws ClassNotFoundException, SQLException {
		
		Accounts account=searchAccountBankDao(mobileNumber);
		if(account.getAmount()-amount<0) {
			return false;
		}
		else {
			Connection connection=ConnectionHelper.getConnection();
			String setNewBalance="update Accounts set amount=? where MobileNo=?";
			PreparedStatement pst2=connection.prepareStatement(setNewBalance);
			pst2.setDouble(1,account.getAmount()- amount);
			pst2.setString(2,mobileNumber);
			pst2.executeUpdate();
			return true;
		}
	}

	@Override
	public boolean loginToBankDao(Accounts account) throws ClassNotFoundException, SQLException {
		
		Connection connection=ConnectionHelper.getConnection();
		String cmd="select * from Accounts where UserName =? and Passcode=?";
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setString(1, account.getUserName());
		pst.setString(2, account.getPassword());
		ResultSet res=pst.executeQuery();
		if(res.next()) {
			account.setMobileNo(res.getString("MobileNo"));
			return true;
		}
		return false;
	}
	

	@Override
	public String sendMoneyBankDao(Accounts userAccount,String senderNumber, int amount) throws ClassNotFoundException, SQLException {
		if(debitMoneyToBankDao(userAccount.getMobileNo(), amount)) {
			if(creditMoneyToBankDao(senderNumber, amount)) {
				return "money transfer successful ";
			}else {
				creditMoneyToBankDao(userAccount.getMobileNo(), amount);
				return "unable to send money to reciever";
			}
		}
		else {
			
			return "The user have insufficient balance ";
		}
	}


	@Override
	public Accounts searchAccountBankDao(String  MobileNo) throws ClassNotFoundException, SQLException {
		Connection connection=ConnectionHelper.getConnection();
		String cmd="select * from Accounts where MobileNo=?";
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setString(1, MobileNo);
		Accounts account=null;
		ResultSet rs=pst.executeQuery();
		if (rs.next()) {
			account=new Accounts();
			account.setAccHolderName(rs.getString("AccHolderName"));
			account.setAccountNo(rs.getInt("AccountNo"));
			account.setAmount(rs.getInt("Amount"));
			account.setEmail(rs.getString("Email"));
			account.setMobileNo(rs.getString("MobileNo"));
			account.setPassword(rs.getString("Passcode"));
			account.setUserName(rs.getString("UserName"));
		}
		return account;
	}

}
