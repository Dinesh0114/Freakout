package com.niit.confi;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.CategoryDAOImpl;
import com.niit.DAO.CustomerDAOImpl;
import com.niit.DAO.ProductDAOImpl;
import com.niit.model.Authorities;
import com.niit.model.BillingAddress;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement

public class Dbconfi {
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	dataSource.setUsername("sa");
	dataSource.setPassword("");
	
	System.out.println("---Data Source Created---");
	return dataSource;
}

@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	
	Properties hibernateProp=new Properties();
	hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
	hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
	factoryBuilder.addAnnotatedClass(Category.class);
	factoryBuilder.addAnnotatedClass(Product.class);
	factoryBuilder.addAnnotatedClass(User.class);
	factoryBuilder.addAnnotatedClass(Customer.class);
	factoryBuilder.addAnnotatedClass(Authorities.class);
	factoryBuilder.addAnnotatedClass(BillingAddress.class);
	factoryBuilder.addAnnotatedClass(ShippingAddress.class);
	factoryBuilder.addAnnotatedClass(Cart.class);
	factoryBuilder.addAnnotatedClass(CartItem.class);
	factoryBuilder.addAnnotatedClass(CustomerOrder.class);
	
	factoryBuilder.addProperties(hibernateProp);
	System.out.println("Creating SessionFactory Bean");
	
	return factoryBuilder.buildSessionFactory();
}	
	@Bean(name="categoryDAO")
public CategoryDAO getCategoryDAO()
{
	System.out.println("----DAO Implementation---");
	return new CategoryDAOImpl();
}
@Bean(name="productDAO")
public ProductDAOImpl getProductDAO()
{
	System.out.println("---Product DAO Implementation ---");
	return new ProductDAOImpl();
}
@Bean(name="customerDAO")
public CustomerDAOImpl getCustomerDAO()
{
	System.out.println("---Customer DAO Implementation ---");
	return new CustomerDAOImpl();
}
/*
@Bean(name="userDAO")
public UserDAOImpl UserDAO()
{
	System.out.println("---User DAO Implementation ---");
	return new UserDAOImpl();
}*/
@Bean(name="txManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	System.out.println("trx manager.......");
return new HibernateTransactionManager(sessionFactory);
}


}
