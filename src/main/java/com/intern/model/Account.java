package com.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account", schema = "public")
public class Account implements Serializable {
	@EmbeddedId
	private AccountIdentity accountIdentity;
	@Column(name = "name", insertable = false, updatable = false, nullable = false)
	private String name;
	@Column(name = "price_in", insertable = false, updatable = false, nullable = false)
	private double priceIn;
	@Column(name = "price_out", insertable = false, updatable = false, nullable = false)
	private double priceOut;
	@Column(name = "note", insertable = false, updatable = false, nullable = false)
	private String note;
	@Column(name = "status", insertable = false, updatable = false, nullable = false)
	private String status;

	public AccountIdentity getAccountIdentity() {
		return accountIdentity;
	}

	public void setAccountIdentity(AccountIdentity accountIdentity) {
		this.accountIdentity = accountIdentity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceIn() {
		return priceIn;
	}

	public void setPriceIn(double priceIn) {
		this.priceIn = priceIn;
	}

	public double getPriceOut() {
		return priceOut;
	}

	public void setPriceOut(double priceOut) {
		this.priceOut = priceOut;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account(AccountIdentity accountIdentity, String name, double priceIn, double priceOut, String note,
			String status) {
		this.accountIdentity = accountIdentity;
		this.name = name;
		this.priceIn = priceIn;
		this.priceOut = priceOut;
		this.note = note;
		this.status = status;
	}

	public Account(String owner, String typeId, String name, double priceIn, double priceOut, String note,
			String status) {
		this.accountIdentity = new AccountIdentity(owner, typeId);
		this.name = name;
		this.priceIn = priceIn;
		this.priceOut = priceOut;
		this.note = note;
		this.status = status;
	}

	public Account() {
	}
}
