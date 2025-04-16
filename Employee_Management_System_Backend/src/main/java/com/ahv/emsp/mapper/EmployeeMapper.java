package com.ahv.emsp.mapper;

import com.ahv.emsp.dto.EmployeeDto;
import com.ahv.emsp.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLasttName(),
				employee.getEmail()
				);
	}
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
	
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
	}
	
}
