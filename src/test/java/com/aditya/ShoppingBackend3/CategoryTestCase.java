package com.aditya.ShoppingBackend3;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.ShoppingBackend3.dao.CategoryRepository;
import com.aditya.ShoppingBackend3.model.Category;

public class CategoryTestCase {
	
	public static AnnotationConfigApplicationContext context;
	public static CategoryRepository categoryRepository;  

	@BeforeClass
	public static void init() {
		
		context=new AnnotationConfigApplicationContext();
        context.scan("com.aditya");
        context.refresh();
        categoryRepository=(CategoryRepository)context.getBean("categoryRepository");
	}
	@Test
	   public void testaddCategory() {
		   
		   Category category =new Category();
		   category.setCategoryName("anjali");
		   category.setCategoryDescription("adi@123");
		   assertEquals("successfull insertion",true,categoryRepository.addCategory(category));
		   
	   }

	
}
