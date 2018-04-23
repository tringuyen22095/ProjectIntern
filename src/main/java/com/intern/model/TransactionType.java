package com.intern.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_type", schema = "public")
public class TransactionType implements Serializable {

	// region -- Fields --

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "note", nullable = true)
	private String note;
	@Column(name = "type", nullable = true)
	private String type;
	@Column(name = "id_parent", nullable = true)
	private String idParent;
	@Column(name = "owner", nullable = true)
	private String owner;
	@Column(name = "create_date", insertable = false, nullable = true)
	private Date createDate;
	@Column(name = "status", insertable = false, nullable = true)
	private String status;

	// end

	// region -- Get set --

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

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

	// end

	// region -- Methods --

	public TransactionType(String id, String name, String note, String type, String idParent, String owner,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.type = type;
		this.idParent = idParent;
		this.owner = owner;
		this.status = status;
	}

	public TransactionType() {
		super();
	}

	// end
}