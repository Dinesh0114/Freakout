package com.niit.DAO;

import com.niit.model.Customer;
import com.niit.model.User;

public interface CustomerDAO {
	public void registerCustomer(Customer customer);
	public boolean isEmailValid(String email);
	public boolean isUsernameValid(String username);
	public User getUser(String username);
}
