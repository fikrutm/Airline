package rest.bank.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import rest.bank.dao.AccountDAO;
import rest.bank.domain.Account;
import rest.bank.domain.Subscription;
import rest.bank.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO;
	
	public AccountServiceImpl() {
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Override
	public void createAccount(Account account) {
		accountDAO.save(account);
	}

	@Override
	public void deposit(Account account, Double amount) {
		Account loadAccount = accountDAO.loadAccount(account.getAccountNumber());
		addInterest(loadAccount);
		loadAccount.deposit(amount);
		accountDAO.update(loadAccount);
	}

	@Override
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")

	public void withdraw(Account account, Double amount) {
		Account loadAccount = accountDAO.loadAccount(account.getAccountNumber());
		accountDAO.update(loadAccount);
	}

	@Override
	public void transferFunds(Account source, Account destination, Double amount) {
		withdraw(source, amount);
		deposit(destination, amount);
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountDAO.findAll();
		return accounts;
	}

//	@Cacheable("rest.bank.domain.Account")
	@Override
	public Account getAccount(String accountNumber) {
		return accountDAO.loadAccount(accountNumber);
	}

	@Override
	public void addInterest(Account account) {
		account.addInterest();
	}
	
	@Override
	public List<Account> findAccountsWithCriteria(Double minimumBalance, Subscription subscription) {
		return accountDAO.findAccountsWithCriteria(minimumBalance, subscription);
	}

}
