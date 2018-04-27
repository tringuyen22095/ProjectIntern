package com.intern.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.AccountDao;
import com.intern.model.Account;
import com.intern.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	// region -- Fields --

	@Autowired
	private AccountDao dao;
	@PersistenceContext
	private EntityManager entityManager;

	// end

	// region -- Methods --

	@Override
	public List<Account> findAccountLikeName(String name, String owner) {
		return dao.getAccountLikeName(name, owner);
	}

	@Override
	public Account save(Account newAccount) {
		dao.save(newAccount);
		return null;
	}

	@Override
	public Account update(Account newAccount) {
		Account account = dao.getAccountById(newAccount.getId());
		if (account != null) {
			account = entityManager.merge(newAccount);
			return account;
		}
		return null;
	}

	@Override
	public Account delete(int id) {
		Account account = dao.getAccountById(id);
		if (account != null) {
			account.setStatus("deactive");
			account = entityManager.merge(account);
			return account;
		}
		return null;
	}

	@Override
	public Account findAccountById(int id) {
		return dao.getAccountById(id);
	}

	// end
	
}