package rest.bank.dao.impl;

import org.springframework.stereotype.Repository;

import rest.bank.dao.CustomerDAO;
import rest.bank.domain.Customer;

@Repository
public class CustomerDAOImp extends GenericDaoImpl<Customer> implements CustomerDAO {
	
	public CustomerDAOImp() {
		super.setDaoType(Customer.class);
	}
	
}
