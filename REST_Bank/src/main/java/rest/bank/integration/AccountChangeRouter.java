 
package rest.bank.integration;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import rest.bank.domain.Account;
import rest.bank.domain.SubscriptionType;
import rest.bank.domain.Subscription;

/**
 * Routes Account Change based on Account Notification service.
 * 
 */
@MessageEndpoint
public class AccountChangeRouter {

    final Logger logger = LoggerFactory.getLogger(AccountChangeRouter.class);
    
    @Router(inputChannel="processAccountChange")
	public List<String> processAccountChange(Account account) {
		List<String> results = new ArrayList<>();
		
	    List<Subscription> subscriptions = account.getSubscriptions();
	    for (Subscription subscription : subscriptions) {
	    	SubscriptionType subscriptionType = subscription.getSubscriptionType();
			results.add(subscriptionType.getName());			
		}
	    
        return results;
	}

}
