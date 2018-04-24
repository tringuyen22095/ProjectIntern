package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.AccountType;

@Repository
public interface AccountTypeDao extends JpaRepository<AccountType, Integer> {
	@Query(nativeQuery = true, value = "SELECT * FROM account_type a WHERE"
			+ " UPPER(a.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	public List<AccountType> getAccountTypeLikeName(@Param("name") String name);

	@Query(nativeQuery = true, value = "SELECT * FROM account_type WHERE a.id = :id")
	public AccountType getAccountTypeById(@Param("id") int id);
}
