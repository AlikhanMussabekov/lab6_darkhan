package ru.ifmo.lab6_darkhan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.lab6_darkhan.repositories.ClientRepository;
import ru.ifmo.lab6_darkhan.services.interfaces.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	final private ClientRepository repository;

	@Autowired
	public ClientServiceImpl(ClientRepository repository) {
		this.repository = repository;
	}

	@Override
	public String getClientsNumbers() {

		StringBuilder result = new StringBuilder();

		repository.findAll().forEach(s -> {
			result.append(s.getClientNumber());
			result.append(" ");
		});

		return result.toString();
	}

	@Override
	public String getClientsOrganizationNames() {
		StringBuilder result = new StringBuilder();

		repository.findAll().forEach(s -> {
			result.append(s.getCompanyName());
			result.append(" ");
		});

		return result.toString();

	}
}
