package com.iktpreobuka.banking_project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.banking_project.model.enumeration.City;
import com.iktpreobuka.banking_project.model.enumeration.Country;
import com.iktpreobuka.banking_project.security.Views;

@Entity
@Table
public class Client {

	@Id
	@GeneratedValue
	@JsonView(Views.Admin.class)
	private Integer id;

	@JsonView(Views.Client.class)
	@Column
	private String name;

	@JsonView(Views.Client.class)
	@Column
	private String surname;

	@JsonView(Views.Client.class)
	@Column
	private Integer personalId;

	@JsonView(Views.Client.class)
	@Column
	private String email;

	@Column
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@JsonView(Views.Client.class)
	@Column
	private String phoneNumber;

	@Column
	private String address;

	@Enumerated(EnumType.STRING)
	@Column
	private City city;

	@Enumerated(EnumType.STRING)
	@Column
	private Country country;

	public Client() {
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Integer personalId) {
		this.personalId = personalId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
