package ru.ifmo.lab6_darkhan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ifmo.lab6_darkhan.services.interfaces.ClientService;

@Controller
public class MainController {

	final ClientService clientService;

	@Autowired
	public MainController(ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("/clients")
	@ResponseBody
	public String getClients(){
		return clientService.getClientsNumbers();
	}

	@GetMapping("/organizationnames")
	@ResponseBody
	public String getClientsOrganizationNames(){
		return clientService.getClientsOrganizationNames();
	}
}
