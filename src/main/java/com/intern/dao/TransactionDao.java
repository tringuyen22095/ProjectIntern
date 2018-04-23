package com.intern.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.Transaction;
import com.intern.model.TransactionIdentity;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, TransactionIdentity> {

	/**
	 * Get transaction, find by owner and date transaction
	 * 
	 * @param dateTransaction
	 *            unique of each record belong to user
	 * @param owner
	 *            user need to be read history transaction
	 * @return only one record
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM transaction u WHERE u.owner = :owner AND"
			+ " u.date_transaction = :date_transaction")
	public Transaction getTransactionByOwnerAndDateTransaction(@Param("date_transaction") Date dateTransaction,
			@Param("owner") String owner);

	/**
	 * Search history transaction of user like type (expense, income, transfer,
	 * adjustment), name (name of type)
	 * 
	 * @param owner
	 *            return list history transaction of user
	 * @param temp
	 *            input text to search
	 * @return List transaction valid with search data input
	 */
	@Query(nativeQuery = true, value = "SELECT u.date_transaction, u.owner, u.account_type, u.transaction_type,"
			+ " u.type, u.price, u.note, u.person, u.status FROM transaction u, transaction_type o"
			+ " WHERE o.id = u.transaction_type AND u.owner = :owner AND"
			+ " (UPPER(o.name) LIKE UPPER(CONCAT('%', :temp, '%')) OR"
			+ " UPPER(u.type) LIKE UPPER(CONCAT('%', :temp, '%')))")
	public List<Transaction> getTransactionLikeAccountTypeAndTransactionTypeAndType(@Param("owner") String owner,
			@Param("temp") String temp);
}