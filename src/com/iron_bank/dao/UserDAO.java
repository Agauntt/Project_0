package com.iron_bank.dao;

import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.model.User;
import com.iron_bank.model.UserDetails;

public interface UserDAO {

	public UserDetails registerDetails(UserDetails uDetails) throws BusinessException;
	

}
