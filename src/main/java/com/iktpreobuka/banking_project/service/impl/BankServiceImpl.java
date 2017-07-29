package com.iktpreobuka.banking_project.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.iktpreobuka.banking_project.model.entity.Bank;
import com.iktpreobuka.banking_project.repository.BankRepository;
import com.iktpreobuka.banking_project.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	private BankRepository bankRepository;

	public BankServiceImpl(final BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}

	@Override
	public Bank findOne(Integer id) {
		return bankRepository.findOne(id);
	}

	@Override
	public List<Bank> findAll() {
		return bankRepository.findAll();
	}

	@Override
	public Bank save(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public Bank update(Bank bank, Integer id) {
		bank.setId(id);
		if (bankRepository.findOne(id) == null) {
			throw new RuntimeException("Bank not found!");
		}
		return bankRepository.save(bank);
	}

	@Override
	public void delete(Integer id) {
		try {
			bankRepository.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Bank can not be deleted because of related accounts.");
		}

	}

}
