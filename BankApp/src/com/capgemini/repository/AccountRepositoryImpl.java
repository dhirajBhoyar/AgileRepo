package com.capgemini.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.capgemini.beans.Account;

public class AccountRepositoryImpl implements AccountRepository{
	
	Map accountDetail = new ConcurrentHashMap<Integer,Object>();
	
	@Override
	public boolean createAccount(Account account)
	{
		if(null == account)
			return false;
		else
			accountDetail.put(account.getAccountNumber(), account);
			
		return true;
	}
	
	@Override
	public boolean deleteAccount(int accountNumber){
		return true;
	}
	
	@Override
	public boolean updateAccount(Account account)
	{
		
		if(accountDetail.containsKey(account.getAccountNumber()))
		{
			accountDetail.replace(account.getAccountNumber(), account);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean withrow(int accountNumber, int amount) {
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		updateAccount(account);
		return false;
	}

}
