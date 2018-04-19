package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.*;

@Repository
public interface AccountDao extends JpaRepository<Account, AccountIdentity> {
	@Query(nativeQuery = true, value = "SELECT * FROM account a WHERE a.owner = :owner AND a.status = 'active'")
	public Account getAccountByOwner(@Param("owner") String owner);

	@Query(nativeQuery = true, value = "SELECT * FROM account a WHERE a.name LIKE CONCAT('%',:name,'%')"
			+ " AND a.status = 'active'")
	public List<Account> getAccountLikeName(@Param("name") String name);
}
