package com.efatura.sistemi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.efatura.sistemi.model.Invoice;
import com.efatura.sistemi.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	private static Logger logger = LoggerFactory.getLogger(Invoice.class);
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@GetMapping("/invoiceList")
	public List<Invoice> listInvoice(){
		return invoiceService.findAll();
	}

	@PostMapping("/saveInvoice")
	public Invoice saveInvoice(@RequestBody Invoice tempInvoice) {
		logger.info("Invoice with registered information  ---> :" + tempInvoice);
		tempInvoice.setId(0);
		invoiceService.saveInvoice(tempInvoice);
		return tempInvoice;
	}
	
	@DeleteMapping("/invoices/{invoiceId}")
	public String deleteInvoice(@PathVariable int invoiceId) {
		Invoice tempInvoice = invoiceService.findById(invoiceId);
	    if(tempInvoice ==null) {
	    	throw new RuntimeException("Invoice id not found : "+invoiceId);
	    }	
	    invoiceService.deleteById(invoiceId);
	    return "Deleted invoice id :"+invoiceId;
	}
}
