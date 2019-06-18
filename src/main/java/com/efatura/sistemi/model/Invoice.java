package com.efatura.sistemi.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="invoice_id")
	private int id;
	@Column(name="ettn_no")
	private String ettn;
	@Column(name="invoice_number")
	private String invoiceNumber;
	@Column(name="invoice_type")
	private String invoiceType;
	@Column(name="money_unit")
	private String moneyUnit;
	@Column(name="invoice_direction")
	private String invoiceDirection;
	@Column(name="sender")
	private String sender;
	@Column(name="receiver")
	private String receiver;
	@Column(name="status")
	private String status;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_price")
	private double productPrice;
	@Column(name="product_count")
	private int productCount;
	@Column(name="vat_rate")
	private int vatRate;
	@Column(name="total_vat_amaount")
	private double totalVatAmount;
	@Column(name="total_amaount")
	private double totalAmount;
	@Column(name="create_user")
	private String  createUser;
	@Column(name="create_date")
	private Date createDate;
	@Column(name="update_date")
	private  Date updateDate;
	

	public Invoice() {
		
	}

	public Invoice(String ettn, String invoiceNumber, String invoiceType, String moneyUnit, String invoiceDirection,
			String sender, String receiver, String status, String productName, double productPrice, int productCount,
			int vatRate, double totalVatAmount, double totalAmount, String createUser, Date createDate,
			Date updateDate) {
		this.ettn = ettn;
		this.invoiceNumber = invoiceNumber;
		this.invoiceType = invoiceType;
		this.moneyUnit = moneyUnit;
		this.invoiceDirection = invoiceDirection;
		this.sender = sender;
		this.receiver = receiver;
		this.status = status;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
		this.vatRate = vatRate;
		this.totalVatAmount = totalVatAmount;
		this.totalAmount = totalAmount;
		this.createUser = createUser;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEttn() {
		return ettn;
	}

	public void setEttn(String ettn) {
		this.ettn = ettn;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getMoneyUnit() {
		return moneyUnit;
	}

	public void setMoneyUnit(String moneyUnit) {
		this.moneyUnit = moneyUnit;
	}

	public String getInvoiceDirection() {
		return invoiceDirection;
	}

	public void setInvoiceDirection(String invoiceDirection) {
		this.invoiceDirection = invoiceDirection;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getVatRate() {
		return vatRate;
	}

	public void setVatRate(int vatRate) {
		this.vatRate = vatRate;
	}

	public double getTotalVatAmount() {
		return totalVatAmount;
	}

	public void setTotalVatAmount(double totalVatAmount) {
		this.totalVatAmount = totalVatAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	

}
