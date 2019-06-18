package com.efatura.sistemi.service;

import java.util.List;

import com.efatura.sistemi.model.Invoice;

public interface InvoiceService {

	
	public Invoice findById(int theId);
	
	public void saveInvoice(Invoice theInvoice);
	
	public void deleteById(int theId);
	
	public Invoice findTopByOrderByIdDesc();
	
	public List<Invoice>findAll();
}
