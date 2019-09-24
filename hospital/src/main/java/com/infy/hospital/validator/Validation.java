package com.infy.hospital.validator;

import java.util.List;

import com.infy.hospital.dto.PatientDTO;

public class Validation {
	public void validate(PatientDTO patient) throws Exception {
		String str = "";
		if (patientIdCheck(patient.getId()))
			str = "Patient id is not set or incorrectly set at json file";
		else if (patientNameCheck(patient.getName()))
			str = "Name not set or incorrectly set at json file";
		else if (patientEmailCheck(patient.getEmail()))
			str = "Email not set or incorrectly set at json file";
		else if (patientPhoneCheck(patient.getPhone()))
			str = "Phone not set or incorrectly set at json file";
		else if (patientEmpIdCheck(patient.getEmpId()))
			str = "Phone not set or incorrectly set at json file";
		else if (patientCompanyCheck(patient.getCompany()))
			str = "Company not set or incorrectly set at json file";
		else if (patientIssueCheck(patient.getIssues()))
			str = "Medical Issues not set or incorrectly set at json file";

		if (!str.equals(""))
			throw new Exception(str);
	}

	private boolean patientIssueCheck(List<String> issues) {
		if (issues.isEmpty())
			return true;
		return false;
	}

	private boolean patientCompanyCheck(String company) {
		if (company.matches(".+"))
			return false;
		return true;
	}

	private boolean patientEmpIdCheck(Integer empId) {
		if (empId / 1000 != 0)
			return false;
		return true;
	}

	private boolean patientPhoneCheck(Long phone) {
		if (phone / 1000000000L != 0)
			return false;
		return true;
	}

	private boolean patientEmailCheck(String email) {
		if (email.matches("[a-zA-Z0-9]+@.+"))
			return false;
		return true;
	}

	private boolean patientNameCheck(String name) {
		if (name.matches("[A-Za-z ]+") && !name.matches("[ ]+"))
			return false;
		return true;
	}

	private boolean patientIdCheck(Integer id) {
		if (id != 0 && id != null)
			return false;
		return true;
	}

}
