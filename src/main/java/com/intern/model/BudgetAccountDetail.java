package com.intern.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "budget_acc_detail", schema = "public")
public class BudgetAccountDetail {

	// region -- Fields --

	@Id
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "budget_id", updatable = false, nullable = false)
	private int budget_id;
	@Column(name = "acc_id", updatable = false, nullable = false)
	private int accId;

	// end

	// region -- Get set --

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBudget_id() {
		return budget_id;
	}

	public void setBudget_id(int budget_id) {
		this.budget_id = budget_id;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	// end

	// region -- Methods --

	public BudgetAccountDetail(int id, int budget_id, int accId) {
		super();
		this.id = id;
		this.budget_id = budget_id;
		this.accId = accId;
	}

	public BudgetAccountDetail() {
		super();
	}

	// end

}