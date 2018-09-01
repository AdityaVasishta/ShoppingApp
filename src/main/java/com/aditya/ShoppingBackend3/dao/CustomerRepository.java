package com.aditya.ShoppingBackend3.dao;

import java.util.List;

import com.aditya.ShoppingBackend3.model.Customer;

public interface CustomerRepository {
	
	boolean addCustomer(Customer customer);
	boolean deleteCustomer(int customerId);
	boolean updateCustomer(Customer customer);
	Customer getCustomer(int customerId);
	List<Customer> getCustomerList();
	
	

}
