package com.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.intern.dao.*;
import com.intern.model.*;
import com.intern.service.*;

public class BudgetAccountDetailServiceImpl implements BudgetAccountDetailService {

	// region -- Fields --

	@Autowired
	private BudgetAccountDetailDao dao;

	// end

	// region -- Methods --

	@Override
	public String save(BudgetAccountDetail newBudgetAccountDetail) {
		dao.save(newBudgetAccountDetail);
		return null;
	}

	@Override
	public List<BudgetAccountDetail> findBudgetAccountDetailById(int id) {
		return dao.getBudgetAccountDetailFromBudgetId(id);
	}

	// end

}