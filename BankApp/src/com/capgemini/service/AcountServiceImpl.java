/**
 * 
 */
package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.repository.AccountRepositoryImpl;

/**
 * @author DBHOYAR
 *
 */
public class AcountServiceImpl implements AccountService{

	AccountRepository accountRepository;
	private static String accountRegex = "[0-9]{5}";
	
	
	@Override
	public Account createAccount(int accountNumber, int amount) throws InsufficientInitialAmountException, InvalidAccountNumberException {
		
		if(amount <500)
		{
			throw new InsufficientInitialAmountException();
		}
		
		if(!String.valueOf(accountNumber).matches(accountRegex))
		{
			throw new InvalidAccountNumberException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		accountRepository= new AccountRepositoryImpl();
		
		accountRepository.createAccount(account);
		return account;
	}

	@Override
	public Account depositAmount(int accountNumber, int amount) throws InsufficientBalanceException, InvalidAccountNumberException {
		if(amount<=0)
			throw new InsufficientBalanceException();
		
		else
			if(!String.valueOf(accountNumber).matches(accountRegex))
				throw new InvalidAccountNumberException();
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		accountRepository= new AccountRepositoryImpl();
		
		accountRepository.updateAccount(account);
		return account;
		
		
	}

	@Override
	public boolean withrowalAmount(int accountNumber, int amount)
			throws InsufficientBalanceException, InvalidAccountNumberException {
		int availableBalance = 10000;
		if(amount>availableBalance)
			throw new InsufficientBalanceException();
		else
			if(!String.valueOf(accountNumber).matches(accountRegex))
				throw new InvalidAccountNumberException();
		
		accountRepository= new AccountRepositoryImpl();
		
		accountRepository.withrow(accountNumber, amount);
		return true;
	}
}
