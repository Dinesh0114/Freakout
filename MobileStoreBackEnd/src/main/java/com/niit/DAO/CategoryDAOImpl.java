package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
@Repository("categoryDAO")
public  class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public boolean addCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
		
	}
	@Transactional
	public boolean updateCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().update(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}

	}
@Transactional
	public boolean deleteCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().delete(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
		
	}
@Transactional
	public Category getCategory(int categoryId) {
	Session session=sessionFactory.openSession();
	Category category=(Category)session.get(Category.class,categoryId);
	return category;
	
	}
@Transactional
	
public List<Category> getCategories() {
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Category");
	System.out.println(query.list());
	//List<Category> listCategories=(List<Category>)query.list();
	return query.list();
}

	

}
