package rest.bank.dao.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import rest.bank.dao.AccountDAO;
import rest.bank.domain.Account;
import rest.bank.domain.Subscription;

@Repository
public class AccountDAOImp extends GenericDaoImpl<Account> implements AccountDAO {
	
	public AccountDAOImp() {
		super.setDaoType(Account.class);
	}

	@Override
	public Account loadAccount(String accountNumber) {
		
		Query query = entityManager.createQuery("select a from Account a  where a.accountNumber =:accountNumber");
		return (Account) query.setParameter("accountNumber", accountNumber).getSingleResult();

	}

	@Override
	public List<Account> findAccountsWithCriteria(Double minimumBalance, Subscription subscription) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		// Typed query - expected results are of the type Account
		CriteriaQuery<Account> query = criteriaBuilder.createQuery(Account.class);
		
		// From part of the clause
		Root<Account> accountRoot = query.from(Account.class);
		
		// The Select
		query.select(accountRoot).distinct(true);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		// subscription & minimumBalance
		if ((subscription!= null) && (minimumBalance != null)) {
			// account minimumBalance greater than price
			Predicate minimumBalancePredicate = criteriaBuilder.greaterThan(accountRoot.get("balance"), minimumBalance);
			
			// Get subscriptions: ForEach subscription.notification = :subscription.notification
			Expression<Set<Subscription>> subscriptions = accountRoot.get("subscriptions");
			Predicate subscriptionPredicate = criteriaBuilder.isMember(subscription, subscriptions);

			// Combine...
			Predicate subscriptionMatchPredicate = criteriaBuilder.and(minimumBalancePredicate, subscriptionPredicate);
			predicateList.add(subscriptionMatchPredicate);
		}

		Predicate[] predicates = new Predicate[predicateList.size()];
		predicateList.toArray(predicates);
		query.where(criteriaBuilder.or(predicates));

		List<Account> accounts = (List<Account>) entityManager.createQuery(query).getResultList();
		
		return accounts;
	}
}
