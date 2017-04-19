package com.capgemini.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.service.AccountService;
import com.capgemini.service.AcountServiceImpl;

public class AccountServiceImplTest {

	AccountService accountService;
	@Before
	public void setUp() throws Exception {
		
		accountService = new AcountServiceImpl();
	}

	@Test(expected = InsufficientInitialAmountException.class)
	public void amountIsLessThan500Test() throws InsufficientInitialAmountException, InvalidAccountNumberException
	{
		accountService.createAccount(101, 300);
	}
	
	@Test
	public void successfullAccountCreatedTest() throws InsufficientInitialAmountException, InvalidAccountNumberException
	{
		Account account = accountService.createAccount(12345, 5000);
		assertEquals(account, accountService.createAccount(12345, 5000));
	}
	
	@Test(expected = InvalidAccountNumberException.class)
	public void invalidAccountNumberTest() throws InsufficientInitialAmountException, InvalidAccountNumberException
	{
		Account account = accountService.createAccount(101, 5000);
		
	}
	
	@Test(expected = InsufficientBalanceException.class)
	public void depositAmountGretterThanZeroTest() throws InsufficientBalanceException, InvalidAccountNumberException 
	{
		Account account = accountService.depositAmount(101, 0);
		
	}
	
	@Test(expected = InvalidAccountNumberException.class)
	public void depositIvalidAccountTest() throws InsufficientBalanceException, InvalidAccountNumberException 
	{
		Account account = accountService.depositAmount(43434324, 5000);
		
	}
	
	@Test
	public void depositAmountSuccessfullTest() throws InsufficientBalanceException, InvalidAccountNumberException 
	{
		Account account = accountService.depositAmount(12345, 5000);
		assertEquals(account, accountService.depositAmount(12345, 5000));
	}
	
	@Test(expected = InsufficientBalanceException.class)
	public void withdrowAmountGretterThanZeroTest() throws InsufficientBalanceException, InvalidAccountNumberException 
	{
		boolean isWithdrow = accountService.withrowalAmount(101,10001);
		
	}
	
	@Test(expected = InvalidAccountNumberException.class)
	public void withdrowIvalidAccountTest() throws InsufficientBalanceException, InvalidAccountNumberException 
	{
		boolean isWithdrow = accountService.withrowalAmount(43434324, 5000);
		
	}
	
	@Test
	public void withdrowAmountSuccessfullTest() throws InsufficientBalanceException, InvalidAccountNumberException 
	{
		boolean isWithdrow = accountService.withrowalAmount(12345, 5000);
		assertEquals(isWithdrow, accountService.withrowalAmount(12345, 5000));
	}
}
