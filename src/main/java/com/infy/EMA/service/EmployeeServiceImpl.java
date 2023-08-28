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
import com.infy.EMA.dto.AddressDTO;
import com.infy.EMA.dto.EmployeeDTO;
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

	@Override
	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		er.deleteById(empId);		
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO ed) {
		// TODO Auto-generated method stub
		Optional<Employee> o=er.findById(ed.getEmpId());
		Employee e=o.get();
		e.setEmployeeContactNumber(ed.getEmployeeContactNumber());
		e.setEmpName(ed.getEmpName());
		e.setAddress(AddressDTO.prepareAddress(ed.getAddress()));
		er.save(e);
		ed=Employee.prepareEmployeeDTO(e);
		
		return ed;
	}
	

}
