package com.intern.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.TransactionIncomeDao;
import com.intern.model.TransactionIncome;
import com.intern.service.TransactionIncomeService;

@Service
@Transactional
public class TransactionIncomeServiceImpl implements TransactionIncomeService {

	// region -- Fields --

	@Autowired
	private TransactionIncomeDao dao;
	@PersistenceContext
	private EntityManager entityManager;

	// end

	// region -- Methods --

	@Override
	public List<TransactionIncome> findTransactionIncomeLikeName(String owner, String name) {
		return dao.getTransactionIncomeLikeName(owner, name);
	}

	@Override
	public TransactionIncome findTransactionIncomeById(int id) {
		return dao.getTransactionIncomeById(id);
	}

	@Override
	public String save(TransactionIncome newTransactionIncome) {
		// String temp = newTransactionType.getIdParent() == null ||
		// newTransactionType.getIdParent().isEmpty() ? "CHD"
		// : "PAR";
		// String[] id = dao.getTransactionTypeId(temp).getId().split(temp);
		// String idAfterSplit = id[1];
		// String tmp = temp + (Integer.parseInt(idAfterSplit) + 1);
		// newTransactionType.setId(tmp);

		dao.save(newTransactionIncome);

		return null;
	}

	@Override
	public TransactionIncome update(TransactionIncome newTransactionIncome) {
		TransactionIncome TransactionIncome = findTransactionIncomeById(newTransactionIncome.getId());
		if (TransactionIncome != null) {
			TransactionIncome = entityManager.merge(newTransactionIncome);
			return TransactionIncome;
		}
		return null;
	}

	@Override
	public TransactionIncome delete(int id) {
		TransactionIncome transactionIncome = findTransactionIncomeById(id);
		if (transactionIncome != null) {
			transactionIncome.setStatus("deactive");
			transactionIncome = entityManager.merge(transactionIncome);
			return transactionIncome;
		}
		return null;
	}

	// end
}