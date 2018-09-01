package com.aditya.ShoppingBackend3.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.ShoppingBackend3.dao.CustomerRepository;
import com.aditya.ShoppingBackend3.model.Customer;
import com.aditya.ShoppingBackend3.model.ShippingAddress;

@Repository("customerRepository")
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public boolean addCustomer(Customer customer) {
		
		// T6ODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
	    try {
		ShippingAddress shippingAddress=customer.getShippingAddress();
	    session.save(customer);
	    session.save(shippingAddress);
	
		return true;
	    }
	    catch(HibernateException e)
	    {
	    	
	    	e.printStackTrace();
	    	return false;
	    }
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
        Session session =sessionFactory.getCurrentSession();
        Customer customer= getCustomer(customerId);
        session.delete(customer);
		return true;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.update(customer);
		return true;
	}

	@Override
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		try {
			
			Customer customer =session.get(Customer.class, customerId);
		     return customer;			
		}
		catch(HibernateException exception){
			exception.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("Select c from Customer c");
		List<Customer> list=(List<Customer>)query.getResultList();
		/*
		 * Customer customer = (Customer)session.load(Customer.class,customerId);
		 * */
		return list;
	}

}
