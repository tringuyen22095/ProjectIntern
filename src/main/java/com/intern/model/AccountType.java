package com.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account", schema = "public")
public class AccountType implements Serializable{
	@Id
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private String id;
	@Column(name = "name", insertable = false, updatable = false, nullable = false)
	private String name;
	@Column(name = "note", insertable = false, updatable = false, nullable = false)
	private String note;
	@Column(name = "status", insertable = false, updatable = false, nullable = false)
	private String status;

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

	public AccountType(String id, String name, String note, String status) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.status = status;
	}

	public AccountType() {
		super();
	}

}
