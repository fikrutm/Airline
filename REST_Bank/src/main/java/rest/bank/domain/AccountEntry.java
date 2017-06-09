package rest.bank.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class AccountEntry extends AbstractEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@NotNull(message="{date.valid}")
	
	@Column
	@Convert(converter= LocalDateAttributeConverter.class)
	private LocalDate date;
	
	@NotNull(message= "{amount.valid}")
	@Column
	private Double amount;
	
	@Column
	@NotEmpty(message="{description.valid}")
	private String description;
	
	@Column
	@NotEmpty(message="{fromAccountNumber.valid}")
	private String fromAccountNumber;
	
	@Column
	@NotEmpty(message="{fromPersonName.valid}")
	private String fromPersonName;

	public AccountEntry(
			LocalDate date, 
			Double amount, 
			String description, 
			String fromAccountNumber,
			String fromPersonName
	) {
		super();
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.fromAccountNumber = fromAccountNumber;
		this.fromPersonName = fromPersonName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getFromPersonName() {
		return fromPersonName;
	}

	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
	}
}
