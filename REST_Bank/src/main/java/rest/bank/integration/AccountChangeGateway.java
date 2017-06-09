 
  
package rest.bank.integration;


import org.springframework.integration.annotation.Gateway;

import rest.bank.domain.Account;


/**
 * Connects the Rest Bank application to an external systems
 * The entry point for the Bus Flow.
 */
public interface AccountChangeGateway {

    /**
     * Process an Account change.
     */
	@Gateway(requestChannel="processAccountChange")
	public void process(Account account);

}
