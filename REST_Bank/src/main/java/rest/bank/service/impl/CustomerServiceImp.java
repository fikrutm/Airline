package rest.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.bank.dao.CustomerDAO;
import rest.bank.domain.Customer;
import rest.bank.service.CustomerService;
@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

		@Autowired
	private CustomerDAO customerDAO;
	
	public CustomerServiceImp() {
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public void createCustomer(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.update(customer);

	}

	@Override
	public Customer getCustomer(Long id) {
		return customerDAO.findOne(id);
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers = customerDAO.findAll();
		return customers;
	}

}
