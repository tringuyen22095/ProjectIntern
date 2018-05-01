package com.intern.service;

import java.util.List;

import com.intern.model.*;

public interface BudgetAccountDetailService {
	String save(BudgetAccountDetail newBudgetAccountDetail);

	List<BudgetAccountDetail> findBudgetAccountDetailById(int id);
}