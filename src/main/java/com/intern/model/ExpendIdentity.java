package com.intern.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExpendIdentity implements Serializable {
	@Column(name = "date_expend", insertable = false, updatable = false, nullable = false)
	private Date dateExpend;
	@Column(name = "owner", insertable = false, updatable = false, nullable = false)
	private String owner;
	@Column(name = "type_id", insertable = false, updatable = false, nullable = false)
	private String typeId;

	public Date getDateExpend() {
		return dateExpend;
	}

	public void setDateExpend(Date dateExpend) {
		this.dateExpend = dateExpend;
	}

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

	public ExpendIdentity(Date dateExpend, String owner, String typeId) {
		super();
		this.dateExpend = dateExpend;
		this.owner = owner;
		this.typeId = typeId;
	}

	public ExpendIdentity() {
		super();
	}

}
