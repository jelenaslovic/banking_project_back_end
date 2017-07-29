package com.iktpreobuka.banking_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iktpreobuka.banking_project.model.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

}
