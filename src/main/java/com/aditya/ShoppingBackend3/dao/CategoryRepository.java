package com.aditya.ShoppingBackend3.dao;

import java.util.List;

import com.aditya.ShoppingBackend3.model.Category;


public interface CategoryRepository {

	boolean addCategory(Category category);
	boolean deleteCategory(int categoryId);
	boolean updateCategory(Category category);
	Category getCategory(int categoryId);
	List<Category> getCategoryList();
	
}
