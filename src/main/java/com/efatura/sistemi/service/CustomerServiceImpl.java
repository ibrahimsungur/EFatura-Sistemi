package com.efatura.sistemi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.efatura.sistemi.model.Customer;
import com.efatura.sistemi.repository.CustomerRepository;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	
	@Override
	public List<Customer> findAll() {
		List<Customer> customers=customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer findById(int theId) {
		Optional<Customer> result = customerRepository.findById(theId);
		 Customer tempCustomer =null;
		 
		 if(result.isPresent()) {
			 tempCustomer=result.get();
		 }else {
			// we didn't find the customer
			 throw new RuntimeException("Did not find employee id - " + theId);
		 }
		return tempCustomer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Date createDate = new Date();
		theCustomer.setCreatedDate(createDate);
		customerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		customerRepository.deleteById(theId);
	}

}
