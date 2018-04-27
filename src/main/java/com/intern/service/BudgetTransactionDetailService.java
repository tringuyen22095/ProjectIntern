package com.intern.service;

import com.intern.model.BudgetTransactionDetail;

public interface BudgetTransactionDetailService {
	String save(BudgetTransactionDetail newBudgetTransactionDetail);

	BudgetTransactionDetail update(BudgetTransactionDetail newBudgetTransactionDetail);

	BudgetTransactionDetail delete(int id);

	BudgetTransactionDetail findBudgetTransactionDetailById(int id);
}