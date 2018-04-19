package com.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expend_type", schema = "public")
public class ExpendType implements Serializable {
	@Id
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private String id;
	@Column(name = "name", insertable = false, updatable = false, nullable = false)
	private String name;
	@Column(name = "note", insertable = false, updatable = false, nullable = false)
	private String note;
	@Column(name = "type", insertable = false, updatable = false, nullable = false)
	private String type;
	@Column(name = "id_parent", insertable = false, updatable = false, nullable = false)
	private String idParent;
	@Column(name = "owner", insertable = false, updatable = false, nullable = false)
	private String owner;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ExpendType(String id, String name, String note, String type, String idParent, String owner, String status) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.type = type;
		this.idParent = idParent;
		this.owner = owner;
		this.status = status;
	}

	public ExpendType() {
		super();
	}

}
