package com.iron_bank.service.impl;

import java.security.MessageDigest;

import com.iron_bank.dao.AccountDAO;
import com.iron_bank.dao.UserDAO;
import com.iron_bank.dao.impl.AccountDaoImpl;
import com.iron_bank.dao.impl.UserDaoImpl;
import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.main.IronBankMain;
import com.iron_bank.model.Account;
import com.iron_bank.model.User;
import com.iron_bank.model.UserDetails;
import com.iron_bank.service.IronBankService;

public class IronBankServiceImpl implements IronBankService {

	private AccountDAO acctDAO;
	private UserDAO uDAO;

	@Override
	public String hashBrowns(String password) {
			
			StringBuffer message=new StringBuffer();
			
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				byte[] hash = md.digest(password.getBytes("UTF-8"));

				for (byte w : hash) {
					message.append(String.format("%02x", w));
				}
				
			}catch (Exception e) {
				System.out.println(e);
			}

		return message.toString();
	}

	@Override
	public User login(User user) throws BusinessException {
		try {
			UserDaoImpl dao = new UserDaoImpl();
			user = dao.authUser(user);
			if(user.getAcctId()!=0) {
				IronBankMain.mainMenu(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public UserDetails signUp(UserDetails uDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account createChecking(Account account) throws BusinessException {
		
		return null;
	}

	@Override
	public UserDetails displayDeails(UserDetails uDetails) throws BusinessException {
		//
		return null;
	}

	@Override
	public Account getAccountById(long acctId) throws BusinessException {
		
		return null;
	}
	
	public AccountDAO getAccountDao() {
		if(acctDAO==null) {
			acctDAO=new AccountDaoImpl();
		}
		return acctDAO;
	}
	
	public UserDAO getUserDao() {
		if(uDAO==null) {
			uDAO = new UserDaoImpl();
		}
		return uDAO;
	}
	
}

