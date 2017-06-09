package rest.email.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EmailText implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
//	String recipientEmail = "tamratmel@gmail.com";
//	String recipientName = "tamrat";
	private String recipientName;
	private String recipientEmail;
	private String subject;
	private Map<String, Object> variables = new HashMap<String, Object>();
	
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public final void setVariable(String name, Object value) {
		variables.put(name, value);
	}
	
	public Map<String, Object> getVariables() {
		return variables;
	}
}