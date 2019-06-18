package com.efatura.sistemi.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.efatura.sistemi.model.Customer;
import com.efatura.sistemi.service.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private static Logger logger = LoggerFactory.getLogger(Customer.class);
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		logger.info("Customer with registered information  ---> :" + customer);
		customer.setId(0);
		System.out.println("Customer:"+customer.getAddress());
		customerService.saveCustomer(customer);
		return customer;
	}
	
	
	@GetMapping("/customerList")
	public List<Customer> list() {
		List<Customer>list=customerService.findAll();
		return list;
	}
	
	@PutMapping("/customer/{customerId}")
	public Customer updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customer) {
		//Customer tempCustomer = customerService.findById(customerId);
		customer.setId(customerId);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer tempCustomer =customerService.findById(customerId);
		//throw exception if null
		if(tempCustomer ==null) {
			throw new RuntimeException("Customer id not found  :"+customerId);
		}
		customerService.deleteById(customerId);
		return "Deleted customer id :"+customerId;
	}

}
