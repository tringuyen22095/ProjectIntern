package com.intern.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "expend", schema = "public")
public class Expend implements Serializable {
	@EmbeddedId
	private ExpendIdentity expendIdentity;
	@Column(name = "expend_type", insertable = false, updatable = false, nullable = false)
	private String expendType;
	@Column(name = "type", insertable = false, updatable = false, nullable = false)
	private String type;
	@Column(name = "price", insertable = false, updatable = false, nullable = false)
	private double price;
	@Column(name = "note", insertable = false, updatable = false, nullable = false)
	private Date note;
	@Column(name = "person", insertable = false, updatable = false, nullable = false)
	private String person;

	public ExpendIdentity getExpendIdentity() {
		return expendIdentity;
	}

	public void setExpendIdentity(ExpendIdentity expendIdentity) {
		this.expendIdentity = expendIdentity;
	}

	public String getExpendType() {
		return expendType;
	}

	public void setExpendType(String expendType) {
		this.expendType = expendType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getNote() {
		return note;
	}

	public void setNote(Date note) {
		this.note = note;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Expend(ExpendIdentity expendIdentity, String expendType, String type, double price, Date note,
			String person) {
		super();
		this.expendIdentity = expendIdentity;
		this.expendType = expendType;
		this.type = type;
		this.price = price;
		this.note = note;
		this.person = person;
	}

	public Expend(Date date_expend, String owner, String typeId, String expendType, String type, double price,
			Date note, String person) {
		super();
		this.expendIdentity = new ExpendIdentity(date_expend, owner, typeId);
		this.expendType = expendType;
		this.type = type;
		this.price = price;
		this.note = note;
		this.person = person;
	}

	public Expend() {
		super();
	}

}
