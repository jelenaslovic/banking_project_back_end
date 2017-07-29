package com.iktpreobuka.banking_project.service;

import java.util.List;

import com.iktpreobuka.banking_project.model.entity.Transaction;

public interface TransactionService {

	Transaction create(Transaction transaction);

	List<Transaction> findByClient(Integer clientId);

}
