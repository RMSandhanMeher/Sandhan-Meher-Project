package com.java.hib;
 
public class Agent {
	
	private int agentID;
	private String name;
	private String city;
	private Gender Gender;
	private String MaritalStatus;
	private double premium;
	
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Gender getGender() {
		return Gender;
	}
	public void setGender(Gender gender) {
		Gender = gender;
	}
	public String getMaritalStatus() {
		return MaritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "Agent [agentID=" + agentID + ", name=" + name + ", city=" + city + ", Gender=" + Gender
				+ ", MaritalStatus=" + MaritalStatus + ", premium=" + premium + "]";
	}
	public Agent(int agentID, String name, String city, com.java.hib.Gender gender, String maritalStatus,
			double premium) {
		this.agentID = agentID;
		this.name = name;
		this.city = city;
		Gender = gender;
		MaritalStatus = maritalStatus;
		this.premium = premium;
	}
	public Agent() {
	}
	
	
	
}
 
 