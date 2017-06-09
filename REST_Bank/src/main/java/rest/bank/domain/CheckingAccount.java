package rest.bank.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class CheckingAccount extends Account {
	
	@JsonCreator
	public CheckingAccount() {
		setInterest(new CheckingInterest());
	}

}
