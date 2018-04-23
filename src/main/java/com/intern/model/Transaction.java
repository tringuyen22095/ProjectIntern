package com.intern.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transaction", schema = "public")
public class Transaction implements Serializable {

	// region -- Fields --

	@EmbeddedId
	private TransactionIdentity transactionIdentity;
	@Column(name = "account_type", updatable = false, nullable = false)
	private String accountType;
	@Column(name = "transaction_type", nullable = true)
	private String transactionType;
	@Column(name = "type", nullable = true)
	private String type;
	@Column(name = "price", nullable = true)
	private double price;
	@Column(name = "note", nullable = true)
	private String note;
	@Column(name = "person", nullable = true)
	private String person;
	@Column(name = "status", insertable = false, nullable = true)
	private String status;

	// end

	// region -- Get set --

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public TransactionIdentity getTransactionIdentity() {
		return transactionIdentity;
	}

	public void setTransactionIdentity(TransactionIdentity transactionIdentity) {
		this.transactionIdentity = transactionIdentity;
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

	public Transaction(TransactionIdentity transactionIdentity, String accountType, String transactionType, String type,
			double price, String note, String person) {
		super();
		this.transactionIdentity = transactionIdentity;
		this.accountType = accountType;
		this.transactionType = transactionType;
		this.type = type;
		this.price = price;
		this.note = note;
		this.person = person;
	}

	public Transaction(Date date_expend, String owner, String accountType, String transactionType, String type,
			double price, String note, String person) {
		super();
		this.transactionIdentity = new TransactionIdentity(date_expend, owner);
		this.accountType = accountType;
		this.transactionType = transactionType;
		this.type = type;
		this.price = price;
		this.note = note;
		this.person = person;
	}

	public Transaction() {
		super();
	}

	// end
}