package com.intern.service;

import java.util.List;

import com.intern.model.BudgetTransactionDetail;

public interface BudgetTransactionDetailService {
	String save(BudgetTransactionDetail newBudgetTransactionDetail);

	List<BudgetTransactionDetail> findBudgetTransactionDetailById(int id);
}