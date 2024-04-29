package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.OrderNotFoundException;
import com.exception.UserNotFoundException;
import com.model.Orders;
import com.model.Product;
import com.model.User;

public interface IOrderManagementRepository {

	 void createUser(User user) throws SQLException;

	 List<Product> getAllProducts() throws SQLException;

	 List<Orders> getAllOrder(int id) throws SQLException;

     void createOrder(int id, int userId, String productName, String username) throws SQLException;

	 void cancelOrder(int userid, int orderid) throws SQLException;

	 String checkRole(int rolecheck) throws SQLException;

	 void createProduct(Product proinsertion) throws SQLException;
}
