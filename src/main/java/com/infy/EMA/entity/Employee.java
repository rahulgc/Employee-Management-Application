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
    private String department;
    private String baseLocation;
    private double employeeSalary;
    private String employeeBandLevel;
    private String employeeContactNumber;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_Id")
    private Address address;
	
	public Employee(int empId, String empName, String department, String baseLocation, double employeeSalary,
			String employeeBandLevel, String employeeContactNumber, Address address) {
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
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
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", department=" + department + ", baseLocation="
				+ baseLocation + ", employeeSalary=" + employeeSalary + ", employeeBandLevel=" + employeeBandLevel
				+ ", employeeContactNumber=" + employeeContactNumber + ", address=" + address + "]";
	}
    public static EmployeeDTO prepareEmployeeDTO(Employee employee){
    	EmployeeDTO e=new EmployeeDTO();
    	e.setBaseLocation(employee.getBaseLocation());
    	e.setDepartment(employee.getDepartment());
    	e.setEmpId(employee.getEmpId());
    	e.setEmpName(employee.getEmpName());
    	e.setEmployeeContactNumber(employee.getEmployeeContactNumber());
    	e.setEmployeeSalary(employee.getEmployeeSalary());
    	e.setEmployeeBandLevel(employee.getEmployeeBandLevel());
    	AddressDTO a=Address.prepareAddressDTO(employee.getAddress());
    	e.setAddress(a);
    	
        
        return e;
        
    	
    }
    
}
