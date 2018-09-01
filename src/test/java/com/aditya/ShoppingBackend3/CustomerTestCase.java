package com.aditya.ShoppingBackend3;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.ShoppingBackend3.dao.CustomerRepository;
import com.aditya.ShoppingBackend3.model.Customer;

public class CustomerTestCase {
	
	public static AnnotationConfigApplicationContext context;
	public static CustomerRepository customerRepository;  

	
	@BeforeClass
	public static void init() {
		
		context=new AnnotationConfigApplicationContext();
        context.scan("com.aditya");
        context.refresh();
        customerRepository=(CustomerRepository)context.getBean("customerRepository");
	}
	@Test
   public void testaddUser() {
	   
	   Customer customer =new Customer();
	   customer.setFirstName("anjali");
	   customer.setPassword("adi@123");
	   assertEquals("successfull insertion",true,customerRepository.addCustomer(customer));
	   
   }
	

}
