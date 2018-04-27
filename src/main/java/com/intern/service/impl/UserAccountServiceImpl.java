package com.intern.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.UserAccountDao;
import com.intern.model.UserAccount;
import com.intern.service.UserAccountService;
import com.intern.utl.Utils;

@Service(value = "userService")
@Transactional
public class UserAccountServiceImpl implements UserAccountService, UserDetailsService {

	// region -- Fields --

	@Autowired
	private UserAccountDao dao;
	@PersistenceContext
	private EntityManager entityManager;

	// end

	// region -- Methods --

	@Override
	public UserAccount findUserAccountByUserName(String userName) {
		return dao.getUserAccountByUserName(userName);
	}

	@Override
	public UserAccount findUserAccountByEmail(String email) {
		return dao.getUserAccountByEmail(email);
	}

	@Override
	public String save(UserAccount newUserAccount) {
		if (findUserAccountByUserName(newUserAccount.getUserName()) == null) {
			if (findUserAccountByEmail(newUserAccount.getEmail()) == null) {
				dao.save(newUserAccount);
				return null;
			}
			return "Email address has existed in DB.";
		}
		return "User name has existed in DB.";
	}

	@Override
	public UserAccount update(UserAccount newUserAccount) {
		UserAccount userAccount = findUserAccountByUserName(newUserAccount.getUserName());
		if (userAccount != null) {
			userAccount = entityManager.merge(newUserAccount);
			return userAccount;
		}
		return null;
	}

	@Override
	public UserAccount delete(String userName) {
		UserAccount userAccount = findUserAccountByUserName(userName);
		if (userAccount != null) {
			userAccount.setStatus("deactive");
			userAccount = entityManager.merge(userAccount);
			return userAccount;
		}
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserAccount user = findUserAccountByUserName(userName);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		String hash = user.getPassword();

		return new org.springframework.security.core.userdetails.User(userName, hash, getAuthorityByUserId());
	}

	@Override
	public List<SimpleGrantedAuthority> getAuthorityByUserId() {
		return Utils.getAuthorities(null);
	}

	// end
}