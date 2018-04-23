package com.intern.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.TransactionDao;
import com.intern.model.Transaction;
import com.intern.model.TransactionIdentity;
import com.intern.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	// region -- Fields --

	@Autowired
	private TransactionDao dao;
	@PersistenceContext
	private EntityManager entityManager;

	// end

	// region -- Methods --

	@Override
	public Transaction detailTransactionByDateTransaction(Date dateTransaction, String owner) {
		return dao.getTransactionByOwnerAndDateTransaction(dateTransaction, owner);
	}

	@Override
	public String save(Transaction newTransaction) {
		dao.save(newTransaction);
		return null;
	}

	@Override
	public List<Transaction> searchTransaction(String owner, String searchString) {
		return dao.getTransactionLikeAccountTypeAndTransactionTypeAndType(owner, searchString);
	}

	@Override
	public Transaction update(Transaction newTransaction) {
		Date date_transaction = newTransaction.getTransactionIdentity().getDateTransaction();
		String owner = newTransaction.getTransactionIdentity().getOwner();
		Transaction transaction = dao.getTransactionByOwnerAndDateTransaction(date_transaction, owner);
		if (transaction != null) {
			transaction = entityManager.merge(newTransaction);
			return transaction;
		}
		return null;
	}

	@Override
	public Transaction delete(TransactionIdentity transactionIdentity) {
		Date date_transaction = transactionIdentity.getDateTransaction();
		String owner = transactionIdentity.getOwner();
		Transaction transaction = dao.getTransactionByOwnerAndDateTransaction(date_transaction, owner);
		if (transaction != null) {
			transaction.setStatus("deactive");
			transaction = entityManager.merge(transaction);
			return transaction;
		}
		return null;
	}

	// end
}