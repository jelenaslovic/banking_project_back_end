package com.iktpreobuka.banking_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.banking_project.model.entity.Client;
import com.iktpreobuka.banking_project.service.ClientService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clients")
public class ClientController {

	private ClientService clientService;

	public ClientController(final ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping
	public List<Client> findAll() {
		return clientService.findAll();
	}

	@GetMapping("/{id}")
	public Client findOne(@PathVariable Integer id) {
		return clientService.findOne(id);
	}

	@PostMapping
	public Client save(@RequestBody Client client) {
		return clientService.save(client);
	}

	@PutMapping("/{id}")
	public Client update(@RequestBody Client client, @PathVariable Integer id) {
		return clientService.update(client, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		clientService.delete(id);
	}

}
