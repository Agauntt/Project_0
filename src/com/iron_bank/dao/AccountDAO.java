package com.iron_bank.dao;

import java.util.List;

import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.model.Account;
import com.iron_bank.model.Transaction;

public interface AccountDAO {

	public List<Account> displayAccounts(long acctId) throws BusinessException;
	public Account registerAccount(Account account) throws BusinessException;
	public Account findAccountById(long id) throws BusinessException;
	public Account makeTransaction(long acctId, long ownerId, double trans) throws BusinessException;
	public Transaction addTransaction(Transaction t) throws BusinessException;
	public List<Transaction> showHistory(long acctId) throws BusinessException;
}
