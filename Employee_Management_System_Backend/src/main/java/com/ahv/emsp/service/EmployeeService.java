package com.ahv.emsp.service;

import java.util.List;

import com.ahv.emsp.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long employeeId);
	List<EmployeeDto> getAllEmployees();
	//update employee by ID
	EmployeeDto updateEployee(Long employeeId, EmployeeDto updatedEmployee);
	//delete employee by id
	void deleteEmployee(Long employeeId);
}
