package rest.bank.service;

import java.util.Collection;
import java.util.List;

import rest.bank.domain.Account;
import rest.bank.domain.Subscription;

public interface AccountService {
	
	public void createAccount(Account account);
	
	public void deposit(Account account, Double amount);
	
	public void withdraw(Account account, Double amount);
	
	public void transferFunds(Account source, Account destination, Double amount);
	
	public Collection<Account> getAllAccounts();
	
	public Account getAccount(String accountNumber);
	
	public void addInterest(Account account);
	
	public List<Account> findAccountsWithCriteria(Double minimumBalance, Subscription subscription);
}
