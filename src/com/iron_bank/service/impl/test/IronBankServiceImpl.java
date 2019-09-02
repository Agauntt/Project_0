package com.iron_bank.service.impl.test;

import java.security.MessageDigest;

import com.iron_bank.dao.impl.UserDaoImpl;
import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.main.IronBankMain;
import com.iron_bank.model.Account;
import com.iron_bank.model.User;
import com.iron_bank.model.UserDetails;
import com.iron_bank.service.IronBankService;

public class IronBankServiceImpl implements IronBankService {


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
			// TODO: handle exception
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
	
}
