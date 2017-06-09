 
package rest.bank.integration;

import rest.bank.domain.Account;
import rest.email.domain.EmailText;

/**
 *  Transform Account from mailChannel to transformedAccountToEmail for JMS
 */
public interface AccountToEmailTextTransformer {

	public EmailText transformAccount(Account account);

}
