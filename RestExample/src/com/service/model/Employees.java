package com.service.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
	private List<EmployeeVO> employees;

	public List<EmployeeVO> getEmployees() {
		if (employees == null)
			employees = new ArrayList<>();
		return employees;
	}

	public void setEmployees(List<EmployeeVO> employees) {
		this.employees = employees;
	}
}
