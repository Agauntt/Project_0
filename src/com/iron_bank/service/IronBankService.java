package com.iron_bank.service;

import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.model.Account;
import com.iron_bank.model.User;
import com.iron_bank.model.UserDetails;


public interface IronBankService {

	public String hashBrowns(String password) throws BusinessException;
	public UserDetails signUp(UserDetails uDetails);
	public User login(User user) throws BusinessException;
	public Account createChecking(Account account) throws BusinessException;
}
