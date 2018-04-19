package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.*;

@Repository
public interface ExpendTypeDao extends JpaRepository<ExpendType, String> {
	@Query(nativeQuery = true, value = "SELECT * FROM expend_type a WHERE (a.owner = :owner OR a.owner is null) AND a.status = 'active'")
	public List<ExpendType> getExpendTypeByOwner(@Param("owner") String owner);

	@Query(nativeQuery = true, value = "SELECT * FROM expend_type a WHERE a.status = 'active' AND a.name LIKE CONCAT('%', :name, '%') AND (a.owner = :owner OR a.owner is null)")
	public List<ExpendType> getExpendTypeLikeName(@Param("owner") String owner, @Param("name") String name);
}
