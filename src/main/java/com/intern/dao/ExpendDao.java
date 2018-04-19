package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.*;

@Repository
public interface ExpendDao extends JpaRepository<Expend, ExpendIdentity> {
	@Query(nativeQuery = true, value = "SELECT * FROM expend u WHERE u.owner = :owner")
	public List<Expend> getExpendByOwner(@Param("owner") String owner);

	@Query(nativeQuery = true, value = "SELECT * FROM expend u WHERE u.expend_type = :expendType")
	public List<Expend> getExpendByExpendType(@Param("expendType") String expendType);
}
