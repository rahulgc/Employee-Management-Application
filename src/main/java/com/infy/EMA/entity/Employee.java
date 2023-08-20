package com.infy.EMA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.infy.EMA.dto.AddressDTO;
import com.infy.EMA.dto.EmployeeDTO;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String employeeContactNumber;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_Id")
    private Address address;
	
	public Employee(int empId, String empName,String employeeContactNumber, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.employeeContactNumber = employeeContactNumber;
		this.address = address;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
		public String getEmployeeContactNumber() {
			return employeeContactNumber;
		}
		public void setEmployeeContactNumber(String employeeContactNumber) {
			this.employeeContactNumber = employeeContactNumber;
		}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", employeeContactNumber=" + employeeContactNumber + ", address=" + address + "]";
	}
    public static EmployeeDTO prepareEmployeeDTO(Employee employee){
    	EmployeeDTO e=new EmployeeDTO();
    	e.setEmpId(employee.getEmpId());
    	e.setEmpName(employee.getEmpName());
    	e.setEmployeeContactNumber(employee.getEmployeeContactNumber());
    	AddressDTO a=Address.prepareAddressDTO(employee.getAddress());
    	e.setAddress(a);
    	
        
        return e;
        
    	
    }
    
}
