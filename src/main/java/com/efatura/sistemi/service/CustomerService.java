package com.efatura.sistemi.service;

import java.util.List;
import com.efatura.sistemi.model.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void saveCustomer(Customer theCustomer);

	public void deleteById(int theId);

	
}
