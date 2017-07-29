package com.iktpreobuka.banking_project.service;

import java.util.List;

import com.iktpreobuka.banking_project.model.entity.Bank;

public interface BankService {

	Bank findOne(Integer id);

	List<Bank> findAll();

	Bank save(Bank bank);

	Bank update(Bank bank, Integer id);

	void delete(Integer id);
}
