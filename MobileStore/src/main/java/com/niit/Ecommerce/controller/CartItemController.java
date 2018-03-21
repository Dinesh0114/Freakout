package com.niit.Ecommerce.controller;



import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CartItemDAO;
import com.niit.DAO.CustomerDAO;
import com.niit.DAO.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.User;

@Controller
public class CartItemController {
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CustomerDAO customerDAO;
	org.springframework.security.core.userdetails.User user;
	@RequestMapping(value="/cart/addtocart/{id}")
public String addToCart(@AuthenticationPrincipal Principal principal,@PathVariable int id){
	Product product=productDAO.getProduct(id);
	
	
	String username=principal.getName();
	User user=customerDAO.getUser(username);
	Customer customer=user.getCustomer();
	Cart cart=customer.getCart();
	
	List<CartItem> cartItems=cart.getCartItems();
	
	for(CartItem cartItem:cartItems){
		if(cartItem.getProduct().getProductId()==id){
			//cartItem.setQuantity(quantity); //update the quantity
			cartItem.setTotalPrice(cartItem.getQuantity() * product.getProductCost()); //update the totalprice
			cartItemDAO.saveOrUpdateCartItem(cartItem); //update cartitem , quantity and totalprice 
			return "redirect:/cart/getcart";
		}
	}
	
	
	CartItem cartItem=new CartItem();
	//cartItem.setQuantity(quantity);
	cartItem.setTotalPrice(cartItem.getQuantity() * product.getProductCost());
	cartItem.setCart(cart);
	cartItem.setProduct(product);
	cartItemDAO.saveOrUpdateCartItem(cartItem);//insert cartitem.
	return "redirect:/cart/getcart";
	
}
	@RequestMapping(value="/cart/getcart")
	public String getCart(@AuthenticationPrincipal Principal principal,Model model){
		String username=principal.getName();
		User user=customerDAO.getUser(username);
		Customer customer=user.getCustomer();
		Cart cart=customer.getCart();
		model.addAttribute("cart",cart);
		return "cart";
	}
	
	
	@RequestMapping(value="/cart/deletecartitem/{cartItemId}")
	public String removeCartItem(@PathVariable int cartItemId){
		cartItemDAO.removeCartItem(cartItemId);
		return "redirect:/cart/getcart";
	}
	@RequestMapping(value="/cart/clearcart/{cartId}")
    public String clearCart(@PathVariable int cartId){
		Cart cart=cartItemDAO.getCart(cartId);
		List<CartItem> cartItems=cart.getCartItems();
		for(CartItem cartItem : cartItems){//for(T v:collection)
			cartItemDAO.removeCartItem(cartItem.getId());//delete from cartitem where id=3
		}
		return "redirect:/cart/getcart";
    }
	@RequestMapping(value="/cart/checkout/{cartId}")
	public String checkout(@PathVariable int cartId,Model model){
		Cart cart=cartItemDAO.getCart(cartId);
		List<CartItem> cartItems=cart.getCartItems();
		
		Customer customer=cart.getCustomer();
		ShippingAddress shippingAddress=customer.getShippingaddress();
		model.addAttribute("shippingaddress",shippingAddress);
		model.addAttribute("cartId",cartId);
		if(cartItems.size()>0) {
		return "shippingAddressForm";
		}else {
			return"redirect:/cart/getcart" ;
			
		}
	}
	// checkout()[shippingaddress,cartid] -> shippingAddressForm [updated shippingaddress,cartid] -> createorder()
	@RequestMapping(value="/cart/createorder/{cartId}")
	//from shippingaddressform.jsp to createOrder method
	public String createOrder(@PathVariable int cartId,
			                 @ModelAttribute ShippingAddress shippingaddress,BindingResult result,
			                  Model model){
		//set the updated shippingaddress for the customer
		//get customer object
		//using cartid , get cart, from cart , get customer,
		//Update shipping address for the customer
		if(result.hasErrors())
			return "shippingAddressForm";
		Cart cart=cartItemDAO.getCart(cartId);
		Customer customer=cart.getCustomer();
		customer.setShippingaddress(shippingaddress);//update shippingaddress set.... where customerid=?
		cart.setCustomer(customer);
		CustomerOrder customerOrder=cartItemDAO.createOrder(cart);//insert into customerorder
		model.addAttribute("order",customerOrder);
		model.addAttribute("cartId",cartId);
		return "orderdetails";
	}
	@RequestMapping(value="/cart/confirm/{cartId}")
	public String confirm(@PathVariable int cartId){
		Cart cart=cartItemDAO.getCart(cartId);
	
		Product product=new Product();
				List<CartItem> cartItems=cart.getCartItems();
		
		for(CartItem cartItem : cartItems){//for(T v:collection)
			
			System.out.println(cartItem.getQuantity());
			
			
			cartItemDAO.removeCartItem(cartItem.getId());//delete from cartitem where id=3
			productDAO.getProduct(cartItem.getId());
		}
		return "thanks";
	}
}
