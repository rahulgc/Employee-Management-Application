package com.infy.EMA.service;

import java.util.List;

import com.infy.EMA.EmployeeException.EmployeeException;
import com.infy.EMA.dto.EmployeeDTO;
import com.infy.EMA.dto.EmployeePerformanceDTO;



public interface EmployeeService {
	public int InsertEmployee(EmployeeDTO ed);
	public EmployeeDTO getEmployee(Integer empId);
	public List<EmployeeDTO> getAllEmployee();
	public EmployeeDTO updateEmployeeSalary(String employeeBandlevel);
    public EmployeePerformanceDTO getEmployeePerformance(Integer empId);
}
