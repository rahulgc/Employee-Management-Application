package com.infy.EMA.dto;

import com.infy.EMA.entity.Address;
import com.infy.EMA.entity.Employee;

public class EmployeeDTO {
	 private int empId;
	    private String empName;
	    private String employeeContactNumber;
	    private AddressDTO address;
	    
	    public EmployeeDTO() {
	    	
	    }
	   
		public EmployeeDTO(int empId, String empName,String employeeContactNumber, AddressDTO address) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.employeeContactNumber = employeeContactNumber;
			this.address = address;
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
		public AddressDTO getAddress() {
			return address;
		}
		public void setAddress(AddressDTO address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "EmployeeDTO [empId=" + empId + ", empName=" + empName +", employeeContactNumber=" + employeeContactNumber + ", address=" + address
					+ "]";
		}
		public static Employee prepareEmployee(EmployeeDTO employee){
	    	Employee e=new Employee();
	    	e.setEmpId(employee.getEmpId());
	    	e.setEmpName(employee.getEmpName());
	    	e.setEmployeeContactNumber(employee.getEmployeeContactNumber());
	        Address a=AddressDTO.prepareAddress(employee.getAddress());
	        e.setAddress(a);
	        
	        return e;
	        
	    	
	    }

		
		}

		
	    


