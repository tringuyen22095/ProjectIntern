package com.intern.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionTypeReq {

	// region -- Fields --

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("note")
	private String note;
	@JsonProperty("type")
	private String type;
	@JsonProperty("id_parent")
	private String idParent;
	@JsonProperty("owner")
	private String owner;

	// end

	// region -- Get set --

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIdParent() {
		return idParent;
	}

	public void setIdParent(String idParent) {
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

	public TransactionTypeReq(String id, String note, String type, String idParent, String owner) {
		super();
		this.id = id;
		this.note = note;
		this.type = type;
		this.idParent = idParent;
		this.owner = owner;
	}

	public TransactionTypeReq() {
		super();
	}
	
	// end
}