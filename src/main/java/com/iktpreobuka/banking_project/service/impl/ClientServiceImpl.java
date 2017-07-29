package com.iktpreobuka.banking_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iktpreobuka.banking_project.model.entity.Client;
import com.iktpreobuka.banking_project.repository.ClientRepository;
import com.iktpreobuka.banking_project.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;

	public ClientServiceImpl(final ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client findOne(Integer id) {
		return clientRepository.findOne(id);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client update(Client client, Integer id) {
		client.setId(id);
		if (clientRepository.findOne(id) == null) {
			throw new RuntimeException("Client not found!");
		}
		return clientRepository.save(client);
	}

	@Override
	public void delete(Integer id) {
		clientRepository.delete(id);
	}

}
