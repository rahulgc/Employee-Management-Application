package com.infy.EMA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.EMA.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	public List<Employee> findByAddress(String Address);

}
