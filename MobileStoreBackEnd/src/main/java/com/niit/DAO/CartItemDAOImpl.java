package com.niit.DAO;

import java.util.Date;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO{
	@Autowired
	private SessionFactory sessionFactory;
		public void saveOrUpdateCartItem(CartItem cartItem) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(cartItem);
		}
		public void removeCartItem(int cartItemId) {
		    Session session=sessionFactory.getCurrentSession();
		    CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		    session.delete(cartItem);
			
		}
		public Cart getCart(int cartId) {
			Session session=sessionFactory.getCurrentSession();
			Cart cart=(Cart)session.get(Cart.class, cartId);
			
			return cart;
		}
		public CustomerOrder createOrder(Cart cart) {
			Session session=sessionFactory.getCurrentSession();
			CustomerOrder customerOrder=new CustomerOrder();
			customerOrder.setPurchaseDate(new Date());
			List<CartItem> cartItems=cart.getCartItems();
			double grandTotal=0;
			for(CartItem cartItem:cartItems){
				grandTotal=cartItem.getTotalPrice() + grandTotal;
			}
			
			cart.setGrandTotal(grandTotal);
			customerOrder.setCart(cart);
			Customer customer=cart.getCustomer();
			customerOrder.setCustomer(customer);
			customerOrder.setBillingAddress(customer.getBillingaddress());
			customerOrder.setShippingAddress(customer.getShippingaddress());
			session.save(customerOrder);
			return customerOrder;
		}

}
