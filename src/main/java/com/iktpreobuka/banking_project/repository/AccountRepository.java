package com.iktpreobuka.banking_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iktpreobuka.banking_project.model.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
