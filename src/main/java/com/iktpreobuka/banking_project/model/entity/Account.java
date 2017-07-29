package com.iktpreobuka.banking_project.model.entity;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.banking_project.security.Views;

@Entity
@Table
public class Account {

	@Id
	@GeneratedValue
	@JsonView(Views.Admin.class)
	private Integer id;

	@JsonView(Views.Client.class)
	@Column
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer number = new Random().nextInt(5000000);

	@JsonView(Views.Client.class)
	@Column
	private Double balance;

	@JsonView(Views.Client.class)
	@Column(name = "account_limit")
	private Double limit;

	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Bank bank;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Account() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getLimit() {
		return limit;
	}

	public void setLimit(Double limit) {
		this.limit = limit;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
