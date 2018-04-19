package com.intern.service.impl;

import com.intern.model.*;
import com.intern.service.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.*;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao dao;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Account findAccountByOwner(String owner) {
		return dao.getAccountByOwner(owner);
	}

	@Override
	public List<Account> findAccountLikeName(String name) {
		return dao.getAccountLikeName(name);
	}

	@Override
	public Account save(Account newAccount) {
		if (findAccountByOwner(newAccount.getAccountIdentity().getOwner()) == null) {
			return dao.save(newAccount);
		}
		return null;
	}

	@Override
	public Account update(Account newAccount) {
		Account account = findAccountByOwner(newAccount.getAccountIdentity().getOwner());
		if (account != null) {
			account = entityManager.merge(newAccount);
			return account;
		}
		return null;
	}

	@Override
	public Account delete(String owner) {
		Account account = findAccountByOwner(owner);
		if (account != null) {
			account.setStatus("deactive");
			account = entityManager.merge(account);
			return account;
		}
		return null;
	}

}
