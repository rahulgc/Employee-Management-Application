package com.infy.EMA.service;

import java.util.List;

import com.infy.EMA.EmployeeException.EmployeeException;
import com.infy.EMA.dto.EmployeeDTO;



public interface EmployeeService {
	public int InsertEmployee(EmployeeDTO ed);
	public EmployeeDTO getEmployee(Integer empId);
	public List<EmployeeDTO> getAllEmployee();
	public void deleteEmployee(Integer empId);
}
