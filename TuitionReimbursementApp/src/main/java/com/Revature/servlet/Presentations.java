package com.Revature.servlet;

public class Presentations {
	private String preID;
	private int dsconfirm = 0;
	private int bcconfirm = 0;
	public int getDsconfirm() {
		return dsconfirm;
	}
	public void setDsconfirm(int dsconfirm) {
		this.dsconfirm = dsconfirm;
	}
	public int getBcconfirm() {
		return bcconfirm;
	}
	public void setBcconfirm(int bcconfirm) {
		this.bcconfirm = bcconfirm;
	}
	public String getPreID() {
		return preID;
	}
	public void setPreID(String preID) {
		this.preID = preID;
	}
	private String eid;
	private String forRid;
	private int availableReimburse;
	private String gradeType;
	private String grade;
	private String coursedate;
	
	public Presentations(String eid, String forRid, int availableReimburse, String gradeType, String grade) {
		this.eid = eid;
		this.forRid = forRid;
		this.availableReimburse = availableReimburse;
		this.gradeType = gradeType;
		this.grade = grade;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getForRid() {
		return forRid;
	}
	public void setForRid(String forRid) {
		this.forRid = forRid;
	}
	public int getAvailableReimburse() {
		return availableReimburse;
	}
	public void setAvailableReimburse(int availableReimburse) {
		this.availableReimburse = availableReimburse;
	}
	public String getGradeType() {
		return gradeType;
	}
	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCoursedate() {
		return coursedate;
	}
	public void setCoursedate(String coursedate) {
		this.coursedate = coursedate;
	}
}
