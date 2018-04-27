package com.intern.service;

import java.util.List;

import com.intern.model.*;

public interface BudgetService {
	String save(Budget newBudget);

	Budget update(Budget newBudget);

	Budget delete(int id);

	List<Budget> findAllBudgetOfOwner(String owner);

	Budget findBudgetById(int id);
}