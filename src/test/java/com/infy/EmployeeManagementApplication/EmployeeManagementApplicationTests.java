package com.infy.EmployeeManagementApplication;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.EMA.EmployeeManagementApplication;
import com.infy.EMA.dto.AddressDTO;
import com.infy.EMA.dto.EmployeeDTO;
import com.infy.EMA.entity.Address;
import com.infy.EMA.entity.Employee;
import com.infy.EMA.repository.EmployeeRepository;
import com.infy.EMA.service.EmployeeService;

@SpringBootTest(classes=EmployeeManagementApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class EmployeeManagementApplicationTests {
//	@Autowired
//	private EmployeeService service;
//	
	@Autowired
	private MockMvc mockmvc;
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		emprepo.deleteAll();
	}
	
	@Test
	public void givenEmployeeObject_CreateEmployee_ReturnSavedEmployee() throws Exception{
		
		//given precondition
		Employee employee= new Employee();
		employee.setEmpName("RajMohan");
		employee.setEmployeeContactNumber("9123456789");
		Address add=new Address();
		add.setCity("Bnagalore");
		add.setPincode("123456");	
		employee.setAddress(add);
		
		//behaviour
		ResultActions response= mockmvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(employee)));
		
		//validate response
		response.andDo(print()).andExpect(status().isCreated());
	}
	}

	
