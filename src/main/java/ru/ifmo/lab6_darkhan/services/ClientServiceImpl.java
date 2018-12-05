package ru.ifmo.lab6_darkhan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.lab6_darkhan.entities.ClientEntity;
import ru.ifmo.lab6_darkhan.repositories.ClientRepository;
import ru.ifmo.lab6_darkhan.services.interfaces.ClientService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

	final private ClientRepository repository;

	@Autowired
	public ClientServiceImpl(ClientRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> getClientsCompanyNames() {
		return new ArrayList<>(repository.selectCompanyNames());
	}

	@Override
	public ClientEntity getClientByCompanyName(String name) {
		return repository.findByCompanyName(name);
	}
}
