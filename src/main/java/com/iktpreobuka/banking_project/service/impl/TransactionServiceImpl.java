package com.iktpreobuka.banking_project.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.iktpreobuka.banking_project.model.entity.Account;
import com.iktpreobuka.banking_project.model.entity.Transaction;
import com.iktpreobuka.banking_project.repository.AccountRepository;
import com.iktpreobuka.banking_project.repository.TransactionRepository;
import com.iktpreobuka.banking_project.service.TransactionService;

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {

	private TransactionRepository transactionRepository;
	private AccountRepository accountRepository;

	public TransactionServiceImpl(final TransactionRepository transactionRepository,
			final AccountRepository accountRepository) {
		this.transactionRepository = transactionRepository;
		this.accountRepository = accountRepository;
	}

	@Override
	public Transaction create(Transaction transaction) {
		Double amountToSend = transaction.getAmount();
		Account senderAccount = accountRepository.findOne(transaction.getSenderAccount().getId());
		Account receiverAccount = accountRepository.findOne(transaction.getReceiverAccount().getId());
		senderAccount.setBalance(senderAccount.getBalance() - amountToSend);
		receiverAccount.setBalance(receiverAccount.getBalance() + amountToSend);
		accountRepository.save(senderAccount);
		accountRepository.save(receiverAccount);
		transaction.setSenderAccount(senderAccount);
		transaction.setReceiverAccount(receiverAccount);
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> findByClient(Integer clientId) {
		List<Transaction> sentTransactions = transactionRepository.findBySenderAccountClientId(clientId);
		List<Transaction> receivedTransactions = transactionRepository.findByReceiverAccountClientId(clientId);
		List<Transaction> allTransactions = new ArrayList<>();
		for (Transaction sentTransaction : sentTransactions) {
			allTransactions.add(sentTransaction);
		}
		for (Transaction receivedTransaction : receivedTransactions) {
			allTransactions.add(receivedTransaction);
		}
		return allTransactions;
	}

}
