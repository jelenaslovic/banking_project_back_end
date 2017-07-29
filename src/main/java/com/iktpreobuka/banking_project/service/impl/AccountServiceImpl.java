package com.iktpreobuka.banking_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iktpreobuka.banking_project.model.entity.Account;
import com.iktpreobuka.banking_project.model.entity.Bank;
import com.iktpreobuka.banking_project.model.entity.Client;
import com.iktpreobuka.banking_project.repository.AccountRepository;
import com.iktpreobuka.banking_project.repository.BankRepository;
import com.iktpreobuka.banking_project.repository.ClientRepository;
import com.iktpreobuka.banking_project.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	private BankRepository bankRepository;
	private ClientRepository clientRepository;

	public AccountServiceImpl(final AccountRepository accountRepository, final BankRepository bankRepository,
			ClientRepository clientRepository) {
		this.accountRepository = accountRepository;
		this.bankRepository = bankRepository;
		this.clientRepository = clientRepository;
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account save(Account account) {

		if (account.getBank() == null) {
			throw new RuntimeException("Bank must be specified!");
		} else if (account.getBank().getId() == null) {
			throw new RuntimeException("Bank must be specified!");
		}

		if (account.getClient() == null) {
			throw new RuntimeException("Client must be specified!");
		} else if (account.getClient().getId() == null) {
			throw new RuntimeException("Client must be specified!");
		}

		Integer bankId = account.getBank().getId();
		Integer clientId = account.getClient().getId();

		Bank bank = bankRepository.findOne(bankId);
		if (bank == null) {
			throw new RuntimeException("Bank not found!");
		}

		Client client = clientRepository.findOne(clientId);
		if (client == null) {
			throw new RuntimeException("Client not found!");
		}

		account.setBank(bank);
		account.setClient(client);
		return accountRepository.save(account);
	}

	@Override
	public Account update(Account account, Integer id) {
		account.setId(id);
		Account currentAccount = accountRepository.findOne(id);
		if (currentAccount == null) {
			throw new RuntimeException("Account not found!");
		}
		account.setBank(currentAccount.getBank());
		account.setClient(currentAccount.getClient());
		return accountRepository.save(account);
	}

	@Override
	public void delete(Integer id) {
		accountRepository.delete(id);
	}

	@Override
	public Account findOne(Integer id) {
		return accountRepository.findOne(id);
	}

}
