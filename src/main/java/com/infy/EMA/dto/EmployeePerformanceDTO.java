package com.infy.EMA.dto;

public class EmployeePerformanceDTO {
	private int empid;
	private int performanceRating;
	private String grade;
	
	
	public EmployeePerformanceDTO() {
		super();
	}


	public EmployeePerformanceDTO(int empid, int performanceRating, String grade) {
		super();
		this.empid = empid;
		this.performanceRating = performanceRating;
		this.grade = grade;
	}


	public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public int getPerformanceRating() {
		return performanceRating;
	}


	public void setPerformanceRating(int performanceRating) {
		this.performanceRating = performanceRating;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}

}
