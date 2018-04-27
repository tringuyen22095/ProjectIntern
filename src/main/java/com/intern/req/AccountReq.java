package com.intern.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountReq {

	// region -- Fields --

	@JsonProperty("owner")
	private String owner;
	@JsonProperty("name")
	private String name;
	@JsonProperty("account_type")
	private String accountType;
	@JsonProperty("ini")
	private double ini;
	@JsonProperty("rmn")
	private double rmn;
	@JsonProperty("note")
	private String note;
	@JsonProperty("status")
	private String status;

	// end

	// region -- Get set --

	public String getOwner() {
		return owner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	// end

	// region -- Methods --

	public AccountReq() {
		super();
	}

	// end
}
