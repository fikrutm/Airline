 
package rest.bank.integration;

import org.springframework.integration.annotation.Transformer;

import rest.bank.domain.Account;
import rest.email.domain.EmailText;

/**
 * Transform Account from mailChannel to transformedAccountToEmail for JMS
 */
public class AccountToEmailTextTransformerImpl implements AccountToEmailTextTransformer {

    @Transformer(inputChannel="mailChannel", outputChannel="transformedAccountToEmail")
	public EmailText transformAccount(Account account) {
    	System.out.println("**********       Transformer received the message       **********");
    	
    	EmailText emailText = new EmailText();
    	emailText.setRecipientEmail("tamratmel@gmail.com");
    	emailText.setRecipientName("tamrat");
    	emailText.setSubject("Account Transaction Info");
    	
    	StringBuilder builder = new StringBuilder();
    	builder.append("Dear XYZ customer:");
    	builder.append("You account balance for account No ").append(account.getAccountNumber());
    	builder.append(" has changed");
    	builder.append("thank you for choosing REST Bank!");
    	
    	emailText.setVariable("accountInfo", builder);
		return emailText;
	}

}
