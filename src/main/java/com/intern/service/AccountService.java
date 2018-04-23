package com.intern.service;

import java.util.List;

import com.intern.model.Account;

public interface AccountService {
	Account findAccountByOwner(String owner);

	List<Account> findAccountLikeName(String name);

	Account save(Account newAccount);

	Account update(Account newAccount);

	Account delete(String owner);
}
