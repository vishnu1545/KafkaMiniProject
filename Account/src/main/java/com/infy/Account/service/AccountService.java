package com.infy.Account.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Account.dta.EmployeeDTO;
import com.infy.Account.entity.Employee;
import com.infy.Account.repository.EmployeesRepository;

@Service
public class AccountService {
 Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EmployeesRepository employeesRepository;

	public EmployeeDTO getEmployee(Integer empId) {
		Optional<Employee> optionalEmployee = employeesRepository.findById(empId);
		if (optionalEmployee.isPresent()) {
			return toEmployeeDTO(optionalEmployee.get());
		} else {
			logger.warn("No Employee with employee Id :{} found by Repository",empId);
			return new EmployeeDTO();
		}
	}

	public EmployeeDTO toEmployeeDTO(Employee employee) {

		EmployeeDTO employeeDto = new EmployeeDTO();
		employeeDto.setEmpId(employee.getEmpId());
		employeeDto.setEmpName(employee.getEmpName());
		employeeDto.setSalary(employee.getSalary());

		return employeeDto;
	}
}
