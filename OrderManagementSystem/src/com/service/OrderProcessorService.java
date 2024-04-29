package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.exception.UserNotFoundException;
import com.model.Orders;
import com.model.Product;
import com.model.User;

public class OrderProcessorService {

	IOrderManagementRepository irmr= new OrderProcessor();
	
	public void createOrder(int userId, int id, String productName, String username) throws SQLException, UserNotFoundException {
		
		irmr.createOrder(id, userId, productName, username);
		
	}

	public void cancelOrder(int userid, int orderid) throws SQLException {
		irmr.cancelOrder(userid,orderid);
		
	}

	public String checkRole(int rolecheck) throws SQLException {
		
		return irmr.checkRole(rolecheck);
	}

	public void createProduct(Product proinsertion) throws SQLException {
		irmr.createProduct(proinsertion);
		
	}

	public void createUser(User user) throws SQLException{
		irmr.createUser(user);
		
	}

	public List<Product> getAllProducts() throws SQLException{
		
		return irmr.getAllProducts();
	}

	public List<Orders> getAllOrder(int id1) throws SQLException {
		
		return irmr.getAllOrder(id1);
	}
	
	

}
