/**
 * 
 */
package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;

/**
 * @author DBHOYAR
 *
 */
public interface AccountService {
	
	public Account createAccount(int accountNumber, int amount)  throws InsufficientInitialAmountException,InvalidAccountNumberException;
	public Account depositAmount(int accountNumber, int amount) throws InsufficientBalanceException, InvalidAccountNumberException;
	public boolean withrowalAmount(int accountNumber, int amount) throws InsufficientBalanceException, InvalidAccountNumberException;

}
