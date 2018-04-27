package com.intern.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.TransactionExpenseDao;
import com.intern.model.TransactionExpense;
import com.intern.service.TransactionExpenseService;

@Service
@Transactional
public class TransactionExpenseServiceImpl implements TransactionExpenseService {

	// region -- Fields --

	@Autowired
	private TransactionExpenseDao dao;
	@PersistenceContext
	private EntityManager entityManager;

	// end

	// region -- Methods --

	@Override
	public List<TransactionExpense> findTransactionExpenseLikeName(String owner, String name) {
		return dao.getTransactionExpenseLikeName(owner, name);
	}

	@Override
	public TransactionExpense findTransactionExpenseById(int id) {
		return dao.getTransactionExpenseById(id);
	}

	@Override
	public String save(TransactionExpense newTransactionExpense) {
		// String temp = newTransactionType.getIdParent() == null ||
		// newTransactionType.getIdParent().isEmpty() ? "CHD"
		// : "PAR";
		// String[] id = dao.getTransactionTypeId(temp).getId().split(temp);
		// String idAfterSplit = id[1];
		// String tmp = temp + (Integer.parseInt(idAfterSplit) + 1);
		// newTransactionType.setId(tmp);

		dao.save(newTransactionExpense);

		return null;
	}

	@Override
	public TransactionExpense update(TransactionExpense newTransactionExpense) {
		TransactionExpense transactionExpense = findTransactionExpenseById(newTransactionExpense.getId());
		if (transactionExpense != null) {
			transactionExpense = entityManager.merge(newTransactionExpense);
			return transactionExpense;
		}
		return null;
	}

	@Override
	public TransactionExpense delete(int id) {
		TransactionExpense transactionExpense = findTransactionExpenseById(id);
		if (transactionExpense != null) {
			transactionExpense.setStatus("deactive");
			transactionExpense = entityManager.merge(transactionExpense);
			return transactionExpense;
		}
		return null;
	}

	// end
}