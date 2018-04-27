package com.intern.service;

import java.util.List;

import com.intern.model.Account;

public interface AccountService {

	List<Account> findAccountLikeName(String name, String owner);

	Account findAccountById(int id);

	Account save(Account newAccount);

	Account update(Account newAccount);

	Account delete(int id);
}