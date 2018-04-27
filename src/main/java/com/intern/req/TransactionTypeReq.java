package com.intern.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionTypeReq {

	// region -- Fields --

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("note")
	private String note;
	@JsonProperty("id_parent")
	private int idParent;
	@JsonProperty("owner")
	private String owner;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	// end

	// region -- Methods --

	public TransactionTypeReq(int id, String note, int idParent, String owner) {
		super();
		this.id = id;
		this.note = note;
		this.idParent = idParent;
		this.owner = owner;
	}

	public TransactionTypeReq() {
		super();
	}

	// end
}