package com.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AccountIdentity implements Serializable {

	// region -- Fields --

	@Column(name = "owner", insertable = false, updatable = false, nullable = false)
	private String owner;
	@Column(name = "type_id", insertable = false, updatable = false, nullable = false)
	private String typeId;

	// end

	// region -- Get set --

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	// end

	// region -- Methods --

	public AccountIdentity(String owner, String typeId) {
		super();
		this.owner = owner;
		this.typeId = typeId;
	}

	public AccountIdentity() {
		super();
	}

	// end
}