package rest.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rest.bank.domain.Account;
import rest.bank.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void createAccount(@RequestBody Account account) {
		accountService.createAccount(account);
	}

	@RequestMapping(value = "{id}/deposite", method = RequestMethod.PUT)
	public void deposit(@PathVariable("id") String accountNumber, Double amount) {
		Account account = accountService.getAccount(accountNumber);
		accountService.deposit(account, amount);
	}

	@RequestMapping(value = "{id}/withdraw", method = RequestMethod.PUT)
	public void withdraw(@PathVariable("id") String accountNumber, Double amount) {
		Account account = accountService.getAccount(accountNumber);
		accountService.withdraw(account, amount);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody Account getAccount(@PathVariable("id") String accountNumber) {
		return accountService.getAccount(accountNumber);
	}

	@RequestMapping(value ="", method = RequestMethod.GET)
	public @ResponseBody List<Account> getAllAccounts() {
		return (List<Account>) accountService.getAllAccounts();
	}

}
