package com.ahv.emsp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahv.emsp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
