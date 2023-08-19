package com.infy.EMA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.EMA.EmployeeException.EmployeeException;
import com.infy.EMA.dto.EmployeeDTO;
import com.infy.EMA.dto.EmployeePerformanceDTO;
import com.infy.EMA.entity.Employee;
import com.infy.EMA.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository er;

	@Override
	public EmployeeDTO getEmployee(Integer empId) {
		Optional<Employee> o=er.findById(empId);
		Employee e=o.get();
		EmployeeDTO ed=Employee.prepareEmployeeDTO(e);
		
		return ed;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> elist=er.findAll();
		List<EmployeeDTO> edlist=new ArrayList();
		for(Employee e:elist) {
			EmployeeDTO ed=Employee.prepareEmployeeDTO(e);
			edlist.add(ed);
		}
		
		return edlist;
	}

	@Override
	public int InsertEmployee(EmployeeDTO ed) {
		Employee e=EmployeeDTO.prepareEmployee(ed);
		er.saveAndFlush(e);
		int id= e.getEmpId();
		return id;
		
	}
	public EmployeeDTO updateEmployeeSalary(String employeeBandLevel) {
		if(employeeBandLevel.equals("A")) {
		Employee A=er.findByEmployeeBandLevel("A");
		A.setEmployeeSalary(A.getEmployeeSalary()*1.15);
		}
		else if(employeeBandLevel.equals("B")) {
		Employee B=er.findByEmployeeBandLevel("B");
		B.setEmployeeSalary(B.getEmployeeSalary()*1.1);
		}
		else if(employeeBandLevel.equals("C")) {
		Employee C=er.findByEmployeeBandLevel("C");
		C.setEmployeeSalary(C.getEmployeeSalary()*1.05);
		}
		
		
		Employee e=er.findByEmployeeBandLevel(employeeBandLevel);
		EmployeeDTO ed=Employee.prepareEmployeeDTO(e);
		
		return ed;
	}

	@Override
	public EmployeePerformanceDTO getEmployeePerformance(Integer empId){
		Optional<Employee> o=er.findById(empId);
		Employee e=o.get();
		EmployeeDTO ed=Employee.prepareEmployeeDTO(e);
		EmployeePerformanceDTO edto=new RestTemplate().getForObject("http://localhost:8083/employeeperformance/"+empId, EmployeePerformanceDTO.class);
		return edto;
	}
	

}
