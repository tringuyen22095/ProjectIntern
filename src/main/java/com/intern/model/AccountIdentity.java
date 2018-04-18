package com.intern.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AccountIdentity implements Serializable {
	@Column(name = "owner", insertable = false, updatable = false, nullable = false)
	private String owner;
	@Column(name = "type_id", insertable = false, updatable = false, nullable = false)
	private String typeId;

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

	public AccountIdentity(String owner, String typeId) {
		super();
		this.owner = owner;
		this.typeId = typeId;
	}

	public AccountIdentity() {
		super();
	}

}
