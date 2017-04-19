/**
 * 
 */
package com.capgemini.repository;

import com.capgemini.beans.Account;

/**
 * @author DBHOYAR
 *
 */
public interface AccountRepository {
	
	public boolean createAccount(Account account);
	
	public boolean deleteAccount(int accountNumber);
	
	public boolean updateAccount(Account account);
	
	public boolean withrow(int accountNumber, int amount);

}
