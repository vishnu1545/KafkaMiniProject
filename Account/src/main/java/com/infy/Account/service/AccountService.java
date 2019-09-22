package com.infy.Account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Account.dta.EmployeeDTO;
import com.infy.Account.entity.Employee;
import com.infy.Account.repository.EmployeesRepository;



@Service
public class AccountService {
	
	@Autowired
	EmployeesRepository repo;
	
	public EmployeeDTO getEmployee(Integer empId) {
	Optional<Employee>	optioEmp=repo.findById(empId);
	EmployeeDTO empDTO=new EmployeeDTO();
	if(optioEmp.isPresent())
	{
		Employee emp=optioEmp.get();
		
		empDTO.setEmpId(emp.getEmpId());
		empDTO.setEmpName(emp.getEmpName());
		empDTO.setSalary(emp.getSalary());
		
	}
	else {
		empDTO.setEmpId(1212);
		empDTO.setEmpName("Vish");
		empDTO.setSalary(5455);
	}
	return empDTO;
	}

}
