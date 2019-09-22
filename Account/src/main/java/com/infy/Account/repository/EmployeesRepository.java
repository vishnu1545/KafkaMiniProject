package com.infy.Account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Account.entity.Employee;

public interface EmployeesRepository extends JpaRepository<Employee, Integer> {

}
