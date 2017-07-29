package com.iktpreobuka.banking_project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.banking_project.model.enumeration.City;
import com.iktpreobuka.banking_project.model.enumeration.Country;
import com.iktpreobuka.banking_project.security.Views;

@Entity
@Table
public class Bank {

	@Id
	@GeneratedValue
	@JsonView(Views.Admin.class)
	private Integer id;

	@Column
	@JsonView(Views.Public.class)
	private String name;

	@Column(name = "PIB")
	@JsonView(Views.Public.class)
	private Integer pib;

	@Column
	private String address;

	@Enumerated(EnumType.STRING)
	@Column
	private City city;

	@Enumerated(EnumType.STRING)
	@Column
	private Country country;

	public Bank() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPib() {
		return pib;
	}

	public void setPib(Integer pib) {
		this.pib = pib;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
