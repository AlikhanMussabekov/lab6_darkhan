package ru.ifmo.lab6_darkhan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.lab6_darkhan.services.interfaces.ClientService;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class MainController {

	final ClientService clientService;

	@Autowired
	public MainController(ClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping("/")
	public String getIndex(){
		return "index.html";
	}

	@GetMapping("/clients")
	@ResponseBody
	public String getClients(){
		return clientService.getClientsNumbers();
	}

	@GetMapping("/companynames")
	@ResponseBody
	public String getClientsOrganizationNames(){
		return clientService.getClientsCompanyNames();
	}
}
