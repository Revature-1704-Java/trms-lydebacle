package com.Revature.servlet;

import java.util.ArrayList;

public class Employees {
	private String username;
	private ArrayList<Reimbursements> listOfReimbursements = new ArrayList<Reimbursements>();
	private String firstname;
	private String lastname;
	private int employeeType;
	
	public int getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Employees() {};
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ArrayList<Reimbursements> getListOfReimbursements() {
		return listOfReimbursements;
	}
	public void setListOfReimbursements(ArrayList<Reimbursements> listOfReimbursements) {
		this.listOfReimbursements = listOfReimbursements;
	}
	
	public void deleteReimbursement(String id) {
		for(int i =0; i< listOfReimbursements.size(); i++) {
			if(Integer.parseInt(id) == listOfReimbursements.get(i).getRID()) {
				listOfReimbursements.remove(listOfReimbursements.get(i));
			}
		};
	}
	
	
}
