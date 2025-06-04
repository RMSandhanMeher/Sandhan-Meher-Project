package com.java.bank.dao;

import java.sql.SQLException;

import com.java.bank.model.Accounts;

public interface BankDao {
	
	public boolean loginToBankDao(Accounts account) throws ClassNotFoundException, SQLException;
	public String sendMoneyBankDao(Accounts userAccount,String senderNumber, int amount) throws ClassNotFoundException, SQLException;
	public Accounts searchAccountBankDao(String  MobileNo) throws ClassNotFoundException, SQLException;
	
}
