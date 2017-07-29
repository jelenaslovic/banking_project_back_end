package com.iktpreobuka.banking_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.banking_project.model.entity.Transaction;
import com.iktpreobuka.banking_project.service.TransactionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private TransactionService transactionService;

	public TransactionController(final TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping("/clients/{clientId}")
	public List<Transaction> findAllByClient(@PathVariable Integer clientId) {
		return transactionService.findByClient(clientId);
	}

	@PostMapping
	public Transaction create(@RequestBody Transaction transaction) {
		return transactionService.create(transaction);
	}

}
