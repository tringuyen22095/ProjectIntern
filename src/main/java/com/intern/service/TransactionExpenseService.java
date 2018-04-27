package com.intern.service;

import java.util.List;

import com.intern.model.TransactionExpense;

public interface TransactionExpenseService {

	List<TransactionExpense> findTransactionExpenseLikeName(String owner, String name);

	TransactionExpense findTransactionExpenseById(int id);

	String save(TransactionExpense newTransactionExpense);

	TransactionExpense update(TransactionExpense newTransactionExpense);

	TransactionExpense delete(int id);
}