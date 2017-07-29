package com.iktpreobuka.banking_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iktpreobuka.banking_project.model.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findBySenderAccountClientId(Integer id);

	List<Transaction> findByReceiverAccountClientId(Integer id);

}
