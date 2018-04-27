package com.intern.service.impl;

import com.intern.model.*;
import com.intern.service.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.*;

@Service
@Transactional
public class BudgetServiceImpl implements BudgetService {

	// region -- Fields --

	@Autowired
	private BudgetDao dao;
	@PersistenceContext
	private EntityManager entityManager;

	// end

	// region -- Methods --

	@Override
	public String save(Budget newBudget) {
		dao.save(newBudget);
		return null;
	}

	@Override
	public Budget update(Budget newBudget) {
		Budget budget = findBudgetById(newBudget.getId());
		if (budget != null) {
			budget = entityManager.merge(newBudget);
			return budget;
		}
		return null;
	}

	@Override
	public Budget delete(int id) {
		Budget budget = findBudgetById(id);
		if (budget != null) {
			budget.setStatus("deactive");
			budget = entityManager.merge(budget);
			return budget;
		}
		return null;
	}

	@Override
	public List<Budget> findAllBudgetOfOwner(String owner) {
		return dao.getAllBudgetOfOwner(owner);
	}

	@Override
	public Budget findBudgetById(int id) {
		return dao.getBudgetById(id);
	}

	// end

}