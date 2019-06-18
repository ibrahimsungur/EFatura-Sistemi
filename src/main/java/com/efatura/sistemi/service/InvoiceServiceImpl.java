package com.efatura.sistemi.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.efatura.sistemi.model.Customer;
import com.efatura.sistemi.model.Invoice;
import com.efatura.sistemi.repository.InvoiceRespository;

@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRespository invoiceRespository;
	

	@Override
	public List<Invoice> findAll() {
		List<Invoice>lists=invoiceRespository.findAll();
		return lists;
	}

	@Override
	public Invoice findById(int theId) {
		Optional<Invoice>result =invoiceRespository.findById(theId);
		Invoice tempInvoice =null;
		if(result.isPresent()) {
			tempInvoice=result.get();
		}else {
			//We didn't find the invoice
			throw new RuntimeException("Did not find invoice id :"+theId);
		}
		return tempInvoice;
	}

	@Override
	public void saveInvoice(Invoice theInvoice) {
		theInvoice.setEttn(createEttn());
		theInvoice.setInvoiceNumber(createInvoiceNumber());
		Date createDate =new Date();
		theInvoice.setCreateDate(createDate);
		invoiceRespository.save(theInvoice);
	}

	@Override
	public void deleteById(int theId) {
		invoiceRespository.deleteById(theId);
	}

	private boolean variableControl(Customer cutomer) {
		return false;
	}

	private String createEttn() {
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		return randomUUIDString;
	}

	
	private String createInvoiceNumber() {
		String invoiceNo = null;

		if (findTopByOrderByIdDesc() == null) {
			String start = "100";
			Date date = new Date();
			@SuppressWarnings("deprecation")
			int year = date.getYear() + 1900;
			long last = 100000000;
			invoiceNo = start + year + last;
		} else {
			String start = "100";
			Date date = new Date();
			@SuppressWarnings("deprecation")
			int year = date.getYear() + 1900;
			Invoice tempInvoice = findTopByOrderByIdDesc();
			String tempInvoiceNo = tempInvoice.getInvoiceNumber();
			String deger = tempInvoiceNo.substring(7, 16);
			System.out.println(deger);
			int tempInvoideIndex = Integer.parseInt(deger) + 1;
			invoiceNo = start + year + tempInvoideIndex;

		}

		return invoiceNo;
	}

	@Override
	public Invoice findTopByOrderByIdDesc() {
		return invoiceRespository.findTopByOrderByIdDesc();

	}
	
	private Date dateFormating() {
		Date createDate = Calendar.getInstance().getTime();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	//	Date date =dt.format(createDate);
		return createDate;
	}

}