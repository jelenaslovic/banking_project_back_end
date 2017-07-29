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

import com.iktpreobuka.banking_project.model.entity.Bank;
import com.iktpreobuka.banking_project.service.BankService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banks")
public class BankController {

	private BankService bankService;

	public BankController(BankService bankService) {
		this.bankService = bankService;
	}

	@GetMapping("/{id}")
	public Bank findOne(@PathVariable Integer id) {
		return bankService.findOne(id);
	}

	@GetMapping
	public List<Bank> findAll() {
		return bankService.findAll();
	}

	@PostMapping
	public Bank save(@RequestBody Bank bank) {
		return bankService.save(bank);
	}

	@PutMapping("/{id}")
	public Bank update(@RequestBody Bank bank, @PathVariable Integer id) {
		return bankService.update(bank, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		bankService.delete(id);
	}

}
