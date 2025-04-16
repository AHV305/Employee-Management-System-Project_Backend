package com.ahv.emsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahv.emsp.dto.EmployeeDto;
import com.ahv.emsp.service.Impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
		super();
		this.employeeServiceImpl = employeeServiceImpl;
	}

	//http://localhost:8080/api/employees
	@PostMapping
	public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeServiceImpl.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//http://localhost:8080/api/employees/7
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeServiceImpl.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	//http://localhost:8080/api/employees
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeServiceImpl.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//http://localhost:8080/api/employees/7
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updatedEmployee(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto = employeeServiceImpl.updateEployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	
	//http://localhost:8080/api/employees/7
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeServiceImpl.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted Successfully!!");
	}
}
