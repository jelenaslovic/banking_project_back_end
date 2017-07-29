package com.iktpreobuka.banking_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.banking_project.model.entity.Account;
import com.iktpreobuka.banking_project.service.AccountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/accounts")
public class AccountController {
	private AccountService accountService;

	@Autowired
	public AccountController(final AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/{id}")
	public Account findOne(@PathVariable Integer id) {
		return accountService.findOne(id);
	}

	@GetMapping
	public List<Account> findAll() {
		return accountService.findAll();
	}

	@PostMapping
	public Account save(@RequestBody Account account) {
		return accountService.save(account);
	}

	@PutMapping("/{id}")
	public Account update(@RequestBody Account account, @PathVariable Integer id) {
		return accountService.update(account, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		accountService.delete(id);
	}

}
