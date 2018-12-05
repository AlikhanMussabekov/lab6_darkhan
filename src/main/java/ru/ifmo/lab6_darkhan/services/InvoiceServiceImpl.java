package ru.ifmo.lab6_darkhan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.lab6_darkhan.entities.ClientEntity;
import ru.ifmo.lab6_darkhan.entities.InvoiceEntity;
import ru.ifmo.lab6_darkhan.repositories.InvoiceRepository;
import ru.ifmo.lab6_darkhan.services.interfaces.InvoiceService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	final private InvoiceRepository invoiceRepository;
	final private ClientServiceImpl clientService;

	@Autowired
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, ClientServiceImpl clientService) {
		this.invoiceRepository = invoiceRepository;
		this.clientService = clientService;
	}

	@Override
	public HashMap<String, Object> getClientInvoiceData(String name) {

		HashMap<String,Object> main = new HashMap<>();

		ClientEntity client = clientService.getClientByCompanyName(name);

		List<String> dates = new ArrayList<>();
		List<Integer> prices = new ArrayList<>();

		invoiceRepository.findAllByClientByClientNumber(client).forEach(s -> {
			dates.add(s.getPurchaceDate().toString());
			prices.add(s.getPrice());
		});

		main.put("labels", dates);
		main.put("data", prices);
		main.put("name", name);

		return main;
	}
}
