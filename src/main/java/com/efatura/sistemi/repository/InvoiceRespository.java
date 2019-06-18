package com.efatura.sistemi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efatura.sistemi.model.Invoice;

public interface InvoiceRespository extends JpaRepository<Invoice, Integer> {

public Invoice	findTopByOrderByIdDesc();

}
