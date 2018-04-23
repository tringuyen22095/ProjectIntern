package com.intern.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransactionIdentity implements Serializable {

	// region -- Fields --

	@Column(name = "date_transaction", insertable = false, updatable = false, nullable = false)
	private Date dateTransaction;
	@Column(name = "owner", updatable = false, nullable = false)
	private String owner;
	@Column(name = "account_type", updatable = false, nullable = false)
	private String accountType;

	// end

	// region -- Get set --

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

	// end

	// region -- Methods --

	public TransactionIdentity(Date dateTransaction, String owner, String accountType) {
		super();
		this.dateTransaction = dateTransaction;
		this.owner = owner;
		this.accountType = accountType;
	}

	public TransactionIdentity() {
		super();
	}

	// end
}