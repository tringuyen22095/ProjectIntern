package com.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account", schema = "public")
public class AccountType implements Serializable {

	// region -- Fields --

	@Id
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private String id;
	@Column(name = "name", insertable = false, updatable = false, nullable = false)
	private String name;

	// end

	// region -- Get set --

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// end

	// region -- Methods --

	public AccountType(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public AccountType() {
		super();
	}

	// end
}