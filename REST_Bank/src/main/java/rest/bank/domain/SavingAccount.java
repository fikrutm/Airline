package rest.bank.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class SavingAccount extends Account {

	@JsonCreator
	public SavingAccount() {
		setInterest(new SavingInterest());
	}

}
