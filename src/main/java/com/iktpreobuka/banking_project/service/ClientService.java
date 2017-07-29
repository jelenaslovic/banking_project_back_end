package com.iktpreobuka.banking_project.service;

import java.util.List;

import com.iktpreobuka.banking_project.model.entity.Client;

public interface ClientService {

	Client findOne(Integer id);

	List<Client> findAll();

	Client save(Client client);

	Client update(Client client, Integer id);

	void delete(Integer id);

}
