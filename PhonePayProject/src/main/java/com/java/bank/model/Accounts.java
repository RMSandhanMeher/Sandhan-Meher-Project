package com.java.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

 private int accountNo;
 private String accHolderName;
 private String userName;
 private String password;
 private String email;
 private String mobileNo;
 private double amount;
}
