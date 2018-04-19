package com.intern.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.*;

@Repository
public interface UserAccountDao extends CrudRepository<UserAccount, String> {
	@Query(nativeQuery = true, value = "SELECT * FROM user_account u WHERE u.email = :email AND u.status = 'active'")
	public UserAccount getUserAccountByEmail(@Param("email") String email);

	@Query(nativeQuery = true, value = "SELECT * FROM user_account u WHERE u.user_name = :userName AND u.status = 'active'")
	public UserAccount getUserAccountByUserName(@Param("userName") String userName);
}
