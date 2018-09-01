package com.aditya.ShoppingBackend3.dao;

import java.util.List;


import com.aditya.ShoppingBackend3.model.Product;

public interface ProductRepository {
	
	boolean addProduct(Product product);
	boolean deleteProduct(int productId);
	boolean updateProduct(Product product);
	Product getProduct(int productId);
	List<Product> getProductList();
	

}
