package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.BudgetAccountDetail;

@Repository
public interface BudgetAccountDetailDao extends JpaRepository<BudgetAccountDetail, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM budget_acc_detail a WHERE a.budget_id = :budget_id")
	public List<BudgetAccountDetail> getBudgetAccountDetailFromBudgetId(@Param("budget_id") int budgetId);

}