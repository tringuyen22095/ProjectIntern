package com.intern.service;

import java.util.List;

import com.intern.model.TransactionType;

public interface TransactionTypeService {

	List<TransactionType> findTransactionTypeLikeName(String owner, String name);

	TransactionType findTransactionTypeById(String id);

	String save(TransactionType newTransactionType);

	TransactionType update(TransactionType newTransactionType);

	TransactionType delete(String id);
}