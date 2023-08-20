package com.infy.EMA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.EMA.EmployeeException.EmployeeException;
import com.infy.EMA.dto.EmployeeDTO;
import com.infy.EMA.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id) throws EmployeeException{
		EmployeeDTO e=service.getEmployee(id);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO){
		int id=service.InsertEmployee(employeeDTO);
		String msg="Employee "+id+" is successfully added";
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
		List<EmployeeDTO> list=service.getAllEmployee();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		service.deleteEmployee(id);
		String msg="Employee "+id+" is successfully deleted";
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
}
