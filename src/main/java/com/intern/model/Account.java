package com.intern.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account", schema = "public")
public class Account {

	// region -- Fields --

	@Id
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "owner", updatable = false, nullable = false)
	private String owner;
	@Column(name = "account_type", nullable = true)
	private String accountType;
	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "ini", updatable = false, nullable = true)
	private double ini;
	@Column(name = "rmn", nullable = true)
	private double rmn;
	@Column(name = "note", nullable = true)
	private String note;
	@Column(name = "status", insertable = false, nullable = false)
	private String status;

	// end

	// region -- Get set --

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setStatus(String status) {
		if (status == null || status.isEmpty()) {
			this.status = "active";
		} else {
			this.status = status;
		}
	}

	// end

	// region -- Methods --

	public Account(int id, String owner, String name, double ini, double rmn, String note, String status,
			String accountType) {
		this.owner = owner;
		this.id = id;
		this.name = name;
		this.accountType = accountType;
		this.ini = ini;
		this.rmn = rmn;
		this.note = note;
		this.status = status;
	}

	public Account() {
	}

	// end
}