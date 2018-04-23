package com.intern.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intern.model.UserAccount;

@Repository
public interface UserAccountDao extends CrudRepository<UserAccount, String> {
	/**
	 * Use for login with google account or facebook account
	 * @param email check email exists in db or not
	 * @return if exists result is not null
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM user_account u WHERE u.email = :email AND u.status = 'active'")
	public UserAccount getUserAccountByEmail(@Param("email") String email);

	/**
	 * Use for check user_name exists in db. (don't check at this function, server response not HttpResult.OK)
	 * @param userName check userName
	 * @return exists not null.
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM user_account u WHERE u.user_name = :userName AND u.status = 'active'")
	public UserAccount getUserAccountByUserName(@Param("userName") String userName);
}