package com.intern.service;

import com.intern.model.*;

public interface BudgetAccountDetailService {
	String save(BudgetAccountDetail newBudgetAccountDetail);

	BudgetAccountDetail update(BudgetAccountDetail newBudgetAccountDetail);

	BudgetAccountDetail delete(int id);

	BudgetAccountDetail findBudgetAccountDetailById(int id);
}