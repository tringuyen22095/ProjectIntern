package com.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class AccountIdentity implements Serializable {

	// region -- Fields --

	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "owner", updatable = false, nullable = false)
	private String owner;

	// end

	// region -- Get set --

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// end

	// region -- Methods --

	public AccountIdentity(String owner, int id) {
		super();
		this.owner = owner;
		this.id = id;
	}

	public AccountIdentity() {
		super();
	}

	// end
}