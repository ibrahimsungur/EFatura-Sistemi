package com.efatura.sistemi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efatura.sistemi.model.Customer;

@Repository("customerRepository")
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{
  
}
