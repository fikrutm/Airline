package rest.bank.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
public abstract class Account extends AbstractEntity {
    
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@NotEmpty(message= "{accountNumber.valid}")
	@Column(length = 255, nullable = false)
	private String accountNumber;
	
	@Valid
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<AccountEntry> accountEntries = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Subscription> subscriptions = new ArrayList<>();
	
	@Valid
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="Account_Customer", joinColumns={@JoinColumn(name="AccountNumber")},  
    inverseJoinColumns={ @JoinColumn(name="Customer_ID", unique=true)} )
	@JsonBackReference
	private Customer customer;
	
	@Min(25)
	@Column
	private Double balance;
	
	@Transient
	private Interest interest;
	
	
	public Account() {
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}
	
	public void deposit(Double amount){
		setBalance(balance + amount);
		
		AccountEntry newAccountEntry = new AccountEntry(
				LocalDate.now(), 
				balance, 
				"description", 
				"fromAccountNumber", 
				"fromPersonName"
		);
		accountEntries.add(newAccountEntry);
	}
	
	public void addInterest(){
		interest.addInterest(this);
	}
	
	
	/* 
	 * getters and setters
	 */

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public List<AccountEntry> getAccountEntries() {
		return accountEntries;
	}

	public void setAccountEntries(List<AccountEntry> accountEntries) {
		this.accountEntries = accountEntries;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + ", balance=" + balance + "]";
	}
}
