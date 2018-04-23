package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.AccountType;

@Repository
public interface AccountTypeDao extends JpaRepository<AccountType, String> {
	@Query(nativeQuery = true, value = "SELECT * FROM expend_type a WHERE a.name LIKE CONCAT('%', :name, '%')"
			+ " AND a.status = 'active'")
	public List<AccountType> getAccountTypeLikeName(@Param("name") String name);
}
