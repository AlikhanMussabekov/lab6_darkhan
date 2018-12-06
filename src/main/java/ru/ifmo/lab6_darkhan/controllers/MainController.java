package ru.ifmo.lab6_darkhan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.lab6_darkhan.services.interfaces.ClientService;
import ru.ifmo.lab6_darkhan.services.interfaces.EmployeeService;
import ru.ifmo.lab6_darkhan.services.interfaces.InvoiceService;

import java.util.List;
import java.util.HashMap;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class MainController {

	final private ClientService clientService;
	final private InvoiceService invoiceService;
	final private EmployeeService employeeService;

	@Autowired
	public MainController(ClientService clientService, InvoiceService invoiceService, EmployeeService employeeService) {
		this.clientService = clientService;
		this.invoiceService = invoiceService;
		this.employeeService = employeeService;
	}

	@RequestMapping("/")
	public String getIndex(){
		return "index.html";
	}

	@GetMapping(value = "/clientinvoices/{name}")
	@ResponseBody
	public HashMap<String,Object> getClientInvoices(@PathVariable(value = "name") final String name){
		return invoiceService.getClientInvoiceData(name);
	}

	@GetMapping(value = "/employeessalary")
	@ResponseBody
	public HashMap<String,Object> getEmployeesSalary(){
		return employeeService.getSalaryAndAge();
	}

	@GetMapping("/companynames")
	@ResponseBody
	public List<String> getClientsOrganizationNames(){
		return clientService.getClientsCompanyNames();
	}

	@GetMapping("/employees")
	@ResponseBody
	public List<String> getEmployeesInfo(){
		return employeeService.getEmployeesInfo();
	}

}
