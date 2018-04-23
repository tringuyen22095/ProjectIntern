package com.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account", schema = "public")
public class Account implements Serializable {

	// region -- Fields --

	@EmbeddedId
	private AccountIdentity accountIdentity;
	@Column(name = "name", insertable = false, updatable = false, nullable = false)
	private String name;
	@Column(name = "ini", insertable = false, updatable = false, nullable = false)
	private double ini;
	@Column(name = "rmn", insertable = false, updatable = false, nullable = false)
	private double rmn;
	@Column(name = "note", insertable = false, updatable = false, nullable = false)
	private String note;
	@Column(name = "status", insertable = false, updatable = false, nullable = false)
	private String status;

	// end

	// region -- Get set --

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

	public double getIni() {
		return ini;
	}

	public void setIni(double ini) {
		this.ini = ini;
	}

	public double getRmn() {
		return rmn;
	}

	public void setRmn(double rmn) {
		this.rmn = rmn;
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

	// end

	// region -- Methods --

	public void setStatus(String status) {
		this.status = status;
	}

	public Account(AccountIdentity accountIdentity, String name, double ini, double rmn, String note, String status) {
		this.accountIdentity = accountIdentity;
		this.name = name;
		this.ini = ini;
		this.rmn = rmn;
		this.note = note;
		this.status = status;
	}

	public Account(String owner, String typeId, String name, double ini, double rmn, String note, String status) {
		this.accountIdentity = new AccountIdentity(owner, typeId);
		this.name = name;
		this.ini = ini;
		this.rmn = rmn;
		this.note = note;
		this.status = status;
	}

	public Account() {
	}

	// end
}