package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;


@Repository("productDAO")


public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	 SessionFactory sessionFactory;
	@Transactional
	 public boolean addProduct(Product product) {
	  // TODO Auto-generated method stub
	  try
	  {
	  sessionFactory.getCurrentSession().save(product);
	  return true;
	  }
	  catch(Exception e)
	  {
	  System.out.println("Exception Arised:"+e);
	  return false;
	  }
	  
	 }
	@Transactional
	 public boolean deleteProduct(Product product) {
	  // TODO Auto-generated method stub
	  try {
	   sessionFactory.getCurrentSession().delete(product);
	   //Product product1=(Product)session.get(Product.class,product.getProductId());
	   
	   return true;
	   }
	   catch(Exception e) {
	    System.out.println("Exception Arised:"+e);
	   return false;
	   }
	  
	 }
	@Transactional
	 public boolean updateProduct(Product product) {
	  // TODO Auto-generated method stub
	  try
	  {
		  sessionFactory.getCurrentSession().update(product);
	  
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
	  return false;
	  
		}
	 }
	@Transactional
	 public Product getProduct(int productId) {
	  // TODO Auto-generated method stub
	  Session session=sessionFactory.openSession();
	  Product product=(Product)session.get(Product.class,productId);
	  return product;
	 }
	@Transactional
	public List<Product> getProductsbasedonCatId(int CategoryId) {

		Session session=sessionFactory.getCurrentSession();
		
		return session.createQuery("from Product p where p.category.categoryId="+":cateId ").setInteger("cateId", CategoryId).list() ; 
	}
	@Transactional
	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		//HQL - Hibernate query Language
		Query query=session.createQuery("from Product");//Select * from Product
		System.out.println(query.list());
		return query.list();
	}
}
