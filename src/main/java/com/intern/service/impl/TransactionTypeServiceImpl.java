package com.intern.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.TransactionTypeDao;
import com.intern.model.TransactionType;
import com.intern.service.TransactionTypeService;

@Service
@Transactional
public class TransactionTypeServiceImpl implements TransactionTypeService {

	// region -- Fields --

	@Autowired
	private TransactionTypeDao dao;
	@PersistenceContext
	private EntityManager entityManager;

	// end

	// region -- Methods --

	@Override
	public List<TransactionType> findTransactionTypeLikeName(String owner, String name) {
		return dao.getTransactionTypeLikeName(owner, name);
	}

	@Override
	public TransactionType findTransactionTypeById(String id) {
		return dao.getTransactionTypeById(id);
	}

	@Override
	public String save(TransactionType newTransactionType) {
		String temp = newTransactionType.getIdParent() == null || newTransactionType.getIdParent().isEmpty() ? "CHD"
				: "PAR";
		String[] id = dao.getTransactionTypeId(temp).getId().split(temp);
		String idAfterSplit = id[1];
		String tmp = temp + (Integer.parseInt(idAfterSplit) + 1);
		newTransactionType.setId(tmp);

		dao.save(newTransactionType);

		return null;
	}

	@Override
	public TransactionType update(TransactionType newTransactionType) {
		TransactionType transactionType = findTransactionTypeById(newTransactionType.getId());
		if (transactionType != null) {
			transactionType = entityManager.merge(newTransactionType);
			return transactionType;
		}
		return null;
	}

	@Override
	public TransactionType delete(String id) {
		TransactionType transactionType = findTransactionTypeById(id);
		if (transactionType != null) {
			transactionType.setStatus("deactive");
			transactionType = entityManager.merge(transactionType);
			return transactionType;
		}
		return null;
	}

	// end
}