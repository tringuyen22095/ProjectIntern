package com.intern.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.TransactionType;

@Repository
public interface TransactionTypeDao extends JpaRepository<TransactionType, String> {
	
	/**
	 * Use for search like name and another transaction type which user had created.
	 * @param owner get transaction which belong to this owner
	 * @param name search like name (upper or lower is same)
	 * @return
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM transaction_type a WHERE a.status = 'active' AND UPPER(a.name)"
			+ " LIKE UPPER(CONCAT('%', :name, '%')) AND (a.owner = :owner OR a.owner is null)"
			+ " ORDER BY a.create_date ASC")
	public List<TransactionType> getTransactionTypeLikeName(@Param("owner") String owner, @Param("name") String name);

	/**
	 * Use for get exact transaction type in db
	 * @param id get with primary key
	 * @return
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM transaction_type a WHERE a.id = :id")
	public TransactionType getTransactionTypeById(@Param("id") String id);

	/**
	 * Get last ID in TransactionType table
	 * 
	 * @param temp
	 *            to know parent type or child type
	 * @return object, get ID to split
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM transaction_type x WHERE SUBSTR(x.id, 0, 4) = :temp"
			+ " ORDER BY x.create_date DESC LIMIT 1")
	public TransactionType getTransactionTypeId(@Param("temp") String temp);
}