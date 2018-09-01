package com.aditya.ShoppingBackend3.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.ShoppingBackend3.dao.CategoryRepository;
import com.aditya.ShoppingBackend3.model.Category;


@Transactional
@Repository("categoryRepository")
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@Autowired
    private SessionFactory sessionFactory;


	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(category);
		return true;

	}

	@Override
	public boolean deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
        Category category= getCategory(categoryId);
        session.delete(category);
		return true;

	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.update(category);
		return true;
	}

	@Override
	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		try {
			
			Category category =session.get(Category.class, categoryId);
		     return category;			
		}
		catch(HibernateException exception){
			exception.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("Select c from Category c");
		List<Category> list=(List<Category>)query.getResultList();
		return list;

	}

}
