package rest.bank.dao;


import java.util.List;

import rest.bank.domain.Account;
import rest.bank.domain.Subscription;

public interface AccountDAO extends GenericDao<Account> {
	
	public Account loadAccount(String accountNumber);
	
	public List<Account> findAccountsWithCriteria(Double minimumBalance, Subscription subscription);

}
