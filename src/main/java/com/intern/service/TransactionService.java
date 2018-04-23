package com.intern.service;

import java.util.Date;
import java.util.List;

import com.intern.model.Transaction;
import com.intern.model.TransactionIdentity;

public interface TransactionService {

	Transaction detailTransactionByDateTransaction(Date dateTransaction, String owner);

	List<Transaction> searchTransaction(String owner, String searchString);

	String save(Transaction newTransaction);

	Transaction update(Transaction newTransaction);

	Transaction delete(TransactionIdentity transactionIdentity);
}