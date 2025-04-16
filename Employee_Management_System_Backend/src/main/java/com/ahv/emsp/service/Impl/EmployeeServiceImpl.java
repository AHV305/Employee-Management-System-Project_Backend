package com.ahv.emsp.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahv.emsp.Repository.EmployeeRepository;
import com.ahv.emsp.dto.EmployeeDto;
import com.ahv.emsp.dto.exception.ResourceNotFoundException;
import com.ahv.emsp.entity.Employee;
import com.ahv.emsp.mapper.EmployeeMapper;
import com.ahv.emsp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).
				orElseThrow(()->new ResourceNotFoundException
						("Employee does not exists with given id : "+employeeId));

		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper
				.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).
				orElseThrow(()->new ResourceNotFoundException
						("Employee does not exists with given id : "+employeeId));
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLasttName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
	
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).
				orElseThrow(()->new ResourceNotFoundException
						("Employee does not exists with given id : "+employeeId));
		employeeRepository.deleteById(employeeId);
	}

}
