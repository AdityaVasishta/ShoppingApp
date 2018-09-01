package com.aditya.ShoppingBackend3.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.ShoppingBackend3.dao.ProductRepository;
import com.aditya.ShoppingBackend3.model.Product;

@Transactional
@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired
    private SessionFactory sessionFactory;


	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(product);
		return true;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
        Product product= getProduct(productId);
        session.delete(product);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.update(product);
		return true;
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		try {
			
			Product product =session.get(Product.class, productId);
		     return product;			
		}
		catch(HibernateException exception){
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("Select p from Product p");
		List<Product> list=(List<Product>)query.getResultList();
		return list;

	}

}
