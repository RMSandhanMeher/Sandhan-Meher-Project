package com.java.bank.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.bank.dao.BankDaoImpl;
import com.java.bank.model.Accounts;

public class Main {
	public static Scanner scanner;
	public static BankDaoImpl bdi;
	public static Accounts account;
	static {
		scanner=new Scanner(System.in);
		bdi= new BankDaoImpl();
	}
	public static boolean loginToBankMain() throws ClassNotFoundException, SQLException {
		 account=new Accounts();
		System.out.println("Enter your userid : ");
		account.setUserName(scanner.next());
		System.out.println("Enter your password : ");
		account.setPassword(scanner.next());
		return  bdi.loginToBankDao(account);
		
	}
	
	public static String sendMoneyBankMain() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter number of whom to pay : ");
		String number=scanner.next();
		System.out.println("Enter amount : ");
		int amount=scanner.nextInt();
		return bdi.sendMoneyBankDao(account, number, amount);
		
	}
	public static double remainingBalance() throws ClassNotFoundException, SQLException {
		return bdi.searchAccountBankDao(account.getMobileNo()).getAmount();
	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcom to PhonePay\n");
		try {
			if(loginToBankMain()) {
				System.out.println("access verified \n");
				sendMoneyBankMain();
				System.out.println("Remaining balance in your account is "+remainingBalance());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
