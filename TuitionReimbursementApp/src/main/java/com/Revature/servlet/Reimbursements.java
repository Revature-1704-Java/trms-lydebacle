package com.Revature.servlet;

public class Reimbursements {
	private int RID;
	private String firstname;
	private String lastname;
	private String typeOfEvent;
	private String date;
	private String courseStartDate;
	private int totalcost;
	private int projectedcost;
	private String description;
	private String justification;
	private String gradingformat;
	private int dsapproval;
	private int dhapproval;
	private int bcapproval;
	private String status;
	
	
	public String getCourseStartDate() {
		System.out.println(courseStartDate);
		return courseStartDate;
	}
	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	
	public int getDsapproval() {
		return dsapproval;
	}
	public void setDsapproval(int dsapproval) {
		this.dsapproval = dsapproval;
	}
	public int getDhapproval() {
		return dhapproval;
	}
	public void setDhapproval(int dhapproval) {
		this.dhapproval = dhapproval;
	}
	public int getBcapproval() {
		return bcapproval;
	}
	public void setBcapproval(int bcapproval) {
		this.bcapproval = bcapproval;
	}
	public int getRID() {
		return RID;
	}
	public int getProjectedcost() {
		return projectedcost;
	}
	public void setProjectedcost(int projectedcost) {
		this.projectedcost = projectedcost;
	}
	public void setRID(int rID) {
		RID = rID;
	}
	public String getGradingformat() {
		return gradingformat;
	}
	public void setGradingformat(int gf) {
		switch(gf) {
		case 1: gradingformat="P/NP";
				break;
		case 2: gradingformat="Letter";
				break;
		case 3:gradingformat="Satisfaction";
				break;
		}
	}
	
	//i,s,s,s,i,s,s,i,i,i
	public Reimbursements(int RID,String firstname, String lastname, String date, int totalcost,
			String description, String justification, int dsapproval, int dhapproval, int bcapproval) {
		super();
		this.RID = RID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
		this.totalcost = totalcost;
		this.description = description;
		this.justification = justification;
		
		
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
	public String getTypeOfEvent() {
		return typeOfEvent;
	}
	public void setTypeOfEvent(int toE) {
		switch(toE) {
		case 1: typeOfEvent="University Courses";
				projectedcost =(int) (this.getTotalcost()* 0.8);
				break;
		case 2: typeOfEvent="Seminars";
				projectedcost =(int) (this.getTotalcost()* 0.6);
				break;
		case 3: typeOfEvent="Certification Prep Classes";
				projectedcost =(int) (this.getTotalcost()* 0.75);
				break;
		case 4: typeOfEvent="Certification";
				projectedcost =(int) (this.getTotalcost()* 1.0);
				break;
		case 5: typeOfEvent="Technical Training";
				projectedcost =(int) (this.getTotalcost()* 0.9);
				break;
		case 6: typeOfEvent="Other";
				projectedcost =(int) (this.getTotalcost()* 0.3);
				break;
	}
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(int st) {
		switch(st) {
			case 0: status="Pending";
					break;
			case 1: status="Approved";
					break;
			case 2: status="Rejected";
					break;
		}
	}
	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
