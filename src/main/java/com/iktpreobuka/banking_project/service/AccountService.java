package com.iktpreobuka.banking_project.service;

import java.util.List;

import com.iktpreobuka.banking_project.model.entity.Account;

public interface AccountService {

	Account findOne(Integer id);

	List<Account> findAll();

	Account save(Account account);

	Account update(Account account, Integer id);

	void delete(Integer id);
}
