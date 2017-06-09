package rest.bank.service;

import java.util.List;

import rest.bank.domain.Customer;

public interface CustomerService {
	
	public void createCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public Customer getCustomer(Long Id);
	
	public List<Customer> getCustomers();

}
