package com.infy.Account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Account.dta.EmployeeDTO;
import com.infy.Account.service.AccountService;

@RestController
@CrossOrigin
public class AccountController {
	
	@Autowired
	AccountService service;
	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
	public EmployeeDTO getCustomerCallDetails(@PathVariable Integer empId) {
		return service.getEmployee(empId);
		
	}
}
