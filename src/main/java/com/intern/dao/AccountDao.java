package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.Account;
import com.intern.model.AccountIdentity;

@Repository
public interface AccountDao extends JpaRepository<Account, AccountIdentity> {

	@Query(nativeQuery = true, value = "SELECT * FROM account a WHERE a.id = :id")
	public Account getAccountById(@Param("id") int id);

	@Query(nativeQuery = true, value = "SELECT * FROM account a WHERE a.name LIKE UPPER(CONCAT('%',:name,'%'))"
			+ " AND a.status = 'active' AND a.owner = :owner")
	public List<Account> getAccountLikeName(@Param("name") String name, @Param("owner") String owner);
}
