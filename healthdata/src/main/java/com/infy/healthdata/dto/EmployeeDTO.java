package com.infy.healthdata.dto;

public class EmployeeDTO {

	private Integer empId;
	private String empName;
	private Integer salary;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public EmployeeDTO(Integer empId, String empName, Integer salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
	public EmployeeDTO() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeesDTO [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}
	 
}
