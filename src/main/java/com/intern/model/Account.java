package com.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account", schema = "public")
public class Account  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "owner", insertable = false, updatable = false, nullable = false)
	private String owner;
	@Column(name = "type_id", insertable = false, updatable = false, nullable = false)
	private String typeId;
	@Column(name = "name", insertable = false, updatable = false, nullable = false)
	private String name;
	@Column(name = "price_in", insertable = false, updatable = false, nullable = false)
	private double priceIn;
	@Column(name = "price_out", insertable = false, updatable = false, nullable = false)
	private double priceOut;
	@Column(name = "note", insertable = false, updatable = false, nullable = false)
	private String note;
	@Column(name = "status", insertable = false, updatable = false, nullable = false)
	private String status;

}
