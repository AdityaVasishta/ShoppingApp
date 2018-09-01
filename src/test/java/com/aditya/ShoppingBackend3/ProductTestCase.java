package com.aditya.ShoppingBackend3;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.ShoppingBackend3.dao.ProductRepository;
import com.aditya.ShoppingBackend3.model.Product;

public class ProductTestCase {

	public static AnnotationConfigApplicationContext context;
	public static ProductRepository productRepository;  

	@BeforeClass
	public static void init() {
		
		context=new AnnotationConfigApplicationContext();
        context.scan("com.aditya");
        context.refresh();
        productRepository=(ProductRepository)context.getBean("productRepository");
	}
	@Test
	   public void testaddCategory() {
		   
		   Product product =new Product();
		   product.setProductName("anjali");
		   product.setProductCost(5000);
		   assertEquals("successfull insertion",true,productRepository.addProduct(product));
		   
	   }
}
