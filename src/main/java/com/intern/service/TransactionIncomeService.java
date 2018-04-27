package com.intern.service;

import java.util.List;

import com.intern.model.TransactionIncome;

public interface TransactionIncomeService {

	List<TransactionIncome> findTransactionIncomeLikeName(String owner, String name);

	TransactionIncome findTransactionIncomeById(int id);

	String save(TransactionIncome newTransactionIncome);

	TransactionIncome update(TransactionIncome newTransactionIncome);

	TransactionIncome delete(int id);
}