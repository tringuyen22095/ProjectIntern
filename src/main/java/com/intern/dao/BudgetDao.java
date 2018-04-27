package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.Budget;

@Repository
public interface BudgetDao extends JpaRepository<Budget, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM account a WHERE a.owner = :owner AND a.status = 'active"
			+ " ORDER BY date_start ASC'")
	public List<Budget> getAllBudgetOfOwner(@Param("owner") String owner);

	@Query(nativeQuery = true, value = "SELECT * FROM budget a WHERE a.id = :id")
	public Budget getBudgetById(@Param("id") int id);

}