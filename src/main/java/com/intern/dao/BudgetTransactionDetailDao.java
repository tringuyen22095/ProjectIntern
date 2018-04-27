package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.BudgetTransactionDetail;

@Repository
public interface BudgetTransactionDetailDao extends JpaRepository<BudgetTransactionDetail, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM budget_trans_detail a WHERE a.budget_id = :budget_id")
	public List<BudgetTransactionDetail> getBudgetTransactionDetailFromBudgetId(@Param("budget_id") int budgetId);

}