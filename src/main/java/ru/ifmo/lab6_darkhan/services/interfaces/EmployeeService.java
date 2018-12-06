package ru.ifmo.lab6_darkhan.services.interfaces;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {
	public HashMap<String,Object> getSalaryAndAge();
	public List<String> getEmployeesInfo();
}
