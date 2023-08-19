package com.infy.EMA.dto;

import com.infy.EMA.entity.Address;
import com.infy.EMA.entity.Employee;

public class EmployeeDTO {
	 private int empId;
	    private String empName;
	    private String department;
	    private String baseLocation;
	    private double employeeSalary;
	    private String employeeBandLevel;
	    private String employeeContactNumber;
	    private AddressDTO address;
	    
	    public EmployeeDTO() {
	    	
	    }
	   
		public EmployeeDTO(int empId, String empName, String department, String baseLocation, double employeeSalary,
				String employeeBandLevel, String employeeContactNumber, AddressDTO address) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.department = department;
			this.baseLocation = baseLocation;
			this.employeeSalary = employeeSalary;
			this.employeeBandLevel = employeeBandLevel;
			this.employeeContactNumber = employeeContactNumber;
			this.address = address;
		}
		
		

		public double getEmployeeSalary() {
			return employeeSalary;
		}

		public void setEmployeeSalary(double employeeSalary) {
			this.employeeSalary = employeeSalary;
		}

		public String getEmployeeBandLevel() {
			return employeeBandLevel;
		}

		public void setEmployeeBandLevel(String employeeBandLevel) {
			this.employeeBandLevel = employeeBandLevel;
		}

		public String getEmployeeContactNumber() {
			return employeeContactNumber;
		}

		public void setEmployeeContactNumber(String employeeContactNumber) {
			this.employeeContactNumber = employeeContactNumber;
		}

		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getBaseLocation() {
			return baseLocation;
		}
		public void setBaseLocation(String baseLocation) {
			this.baseLocation = baseLocation;
		}
		public AddressDTO getAddress() {
			return address;
		}
		public void setAddress(AddressDTO address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", department=" + department
					+ ", baseLocation=" + baseLocation + ", employeeSalary=" + employeeSalary + ", employeeBandLevel="
					+ employeeBandLevel + ", employeeContactNumber=" + employeeContactNumber + ", address=" + address
					+ "]";
		}
		public static Employee prepareEmployee(EmployeeDTO employee){
	    	Employee e=new Employee();
	    	e.setBaseLocation(employee.getBaseLocation());
	    	e.setDepartment(employee.getDepartment());
	    	e.setEmpId(employee.getEmpId());
	    	e.setEmpName(employee.getEmpName());
	    	e.setEmployeeContactNumber(employee.getEmployeeContactNumber());
	    	e.setEmployeeSalary(employee.getEmployeeSalary());
	    	e.setEmployeeBandLevel(employee.getEmployeeBandLevel());
	        Address a=AddressDTO.prepareAddress(employee.getAddress());
	        e.setAddress(a);
	        
	        return e;
	        
	    	
	    }

		
		}

		
	    


