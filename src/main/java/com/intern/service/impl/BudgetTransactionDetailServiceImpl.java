package com.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.BudgetTransactionDetailDao;
import com.intern.model.BudgetTransactionDetail;
import com.intern.service.BudgetTransactionDetailService;

@Service
@Transactional
public class BudgetTransactionDetailServiceImpl implements BudgetTransactionDetailService {

	// region -- Fields --

	@Autowired
	private BudgetTransactionDetailDao dao;

	// end

	// region -- Methods --

	@Override
	public String save(BudgetTransactionDetail newBudgetTransactionDetail) {
		dao.save(newBudgetTransactionDetail);
		return null;
	}

	@Override
	public List<BudgetTransactionDetail> findBudgetTransactionDetailById(int id) {
		return dao.getBudgetTransactionDetailFromBudgetId(id);
	}

	// end

}