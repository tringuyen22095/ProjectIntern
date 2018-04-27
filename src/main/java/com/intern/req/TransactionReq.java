package com.intern.req;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionReq {

	// region -- Fields --

	@JsonProperty("date_transaction")
	private Date dateTransaction;
	@JsonProperty("owner")
	private String owner;
	@JsonProperty("account_type")
	private String accountType;
	@JsonProperty("transaction_type")
	private String transactionType;
	@JsonProperty("type")
	private String type;
	@JsonProperty("price")
	private double price;
	@JsonProperty("note")
	private String note;
	@JsonProperty("person")
	private String person;
	@JsonProperty("status")
	private String status;

	// end

	// region -- Get set --

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	// end

	// region -- Methods --

	public TransactionReq() {
		super();
	}

	// end
}