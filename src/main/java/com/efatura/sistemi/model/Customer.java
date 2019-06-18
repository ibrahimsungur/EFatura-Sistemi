package com.efatura.sistemi.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "taxIdentificationNumber")
	private String taxIdentificationNumber;
	@Column(name = "email")
	@Email(message = "Hatali email")
	private String email;
	@Column(name = "phoneNumber")
	private String phoneNumber;
	@Column(name = "status")
	private String status;
	@Column(name = "createdUser")
	private String createdUser;
	@Column(name = "serialPrefix")
	private String serialPrefix;
	@Column(name = "createdDate")
	private Date createdDate;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "district")
	private String district;
	@Column(name = "country")
	private String country;

	public Customer() {

	}

	
	
	public Customer(String title, String taxIdentificationNumber, @Email(message = "Hatali email") String email,
			String phoneNumber, String status, String createdUser, String serialPrefix, Date createdDate,
			String address, String city, String district, String country) {
		super();
		this.title = title;
		this.taxIdentificationNumber = taxIdentificationNumber;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.createdUser = createdUser;
		this.serialPrefix = serialPrefix;
		this.createdDate = createdDate;
		this.address = address;
		this.city = city;
		this.district = district;
		this.country = country;
	}



	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getTaxIdentificationNumber() {
		return taxIdentificationNumber;
	}

	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		this.taxIdentificationNumber = taxIdentificationNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getSerialPrefix() {
		return serialPrefix;
	}

	public void setSerialPrefix(String serialPrefix) {
		this.serialPrefix = serialPrefix;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
