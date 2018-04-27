package com.intern.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "budget", schema = "public")
public class Budget {

	// region -- Fields --

	@Id
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "owner", updatable = false, nullable = true)
	private String owner;
	@Column(name = "name", nullable = true)
	private String name;
	@Column(name = "ini", updatable = false, nullable = true)
	private double ini;
	@Column(name = "rmn", nullable = true)
	private double rmn;
	@Column(name = "date_start", nullable = true)
	private Date date_start;
	@Column(name = "repeat", nullable = true)
	private String repeat;
	@Column(name = "status", insertable = false, nullable = true)
	private String status;

	// end

	// region -- Get set --

	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getIni() {
		return ini;
	}

	public void setIni(double ini) {
		this.ini = ini;
	}

	public double getRmn() {
		return rmn;
	}

	public void setRmn(double rmn) {
		this.rmn = rmn;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	// end

	// region -- Methods --

	public Budget(int id, String owner, String name, double ini, double rmn, Date date_start, String repeat,
			String status) {
		super();
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.ini = ini;
		this.rmn = rmn;
		this.date_start = date_start;
		this.repeat = repeat;
		this.status = status;
	}

	public Budget() {
		super();
	}

	// end

}