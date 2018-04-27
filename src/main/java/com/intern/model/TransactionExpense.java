package com.intern.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_expense", schema = "public")
public class TransactionExpense {

	// region -- Fields --

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "note", nullable = true)
	private String note;
	@Column(name = "id_parent", nullable = true)
	private int idParent;
	@Column(name = "owner", nullable = true)
	private String owner;
	@Column(name = "create_date", insertable = false, nullable = true)
	private Date createDate;
	@Column(name = "status", insertable = false, nullable = true)
	private String status;

	// end

	// region -- Get set --

	public int getId() {
		return id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setId(int id) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status == null || status.isEmpty()) {
			this.status = "active";
		} else {
			this.status = status;
		}
	}

	// end

	// region -- Methods --

	public TransactionExpense(int id, String name, String note, int idParent, String owner, Date createDate,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.idParent = idParent;
		this.owner = owner;
		this.createDate = createDate;
		this.status = status;
	}

	public TransactionExpense() {
		super();
	}

	// end
}