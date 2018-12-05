package ru.ifmo.lab6_darkhan.services.interfaces;

import ru.ifmo.lab6_darkhan.entities.ClientEntity;

import java.util.List;

public interface ClientService {
	public List<String> getClientsCompanyNames();
	public ClientEntity getClientByCompanyName(String name);
}
