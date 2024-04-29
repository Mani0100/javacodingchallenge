package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Orders;
import com.model.Product;
import com.model.User;
import com.utility.DBUtil;

public class OrderProcessor implements IOrderManagementRepository{

	@Override
	public void createUser(User user) throws SQLException {
		Connection con=DBUtil.dbConnect();
		String sql = "INSERT INTO user(username,password,role) VALUES(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		String userName= user.getUsername();
		String password=user.getPassword();
		String role=user.getRole();
		pstmt.setString(1, userName);
		pstmt.setString(2, password);
		pstmt.setString(3, role);
		int changes=pstmt.executeUpdate();
		if(changes==0)
			System.out.println("Error....No updates have been done");
		else
			System.out.println("New User has been Inserted succesfully...");
		System.out.println("User ID: "+user.getUserId()+"\nUserName: "+userName+"\npassword: "+password+"\nRole: "+role);
		DBUtil.dbclose();
		
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		
		List<Product> list = new ArrayList<>();
		Connection con=DBUtil.dbConnect();
		String sql = "select * from product";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			int id = rst.getInt("id");
			String productName = rst.getString("product_name");
			String description = rst.getString("description");
			int price = rst.getInt("price");
			int quantity= rst.getInt("quantity_in_stock");
			String type = rst.getString("type");
			Product p = new Product(id,productName,description,price,quantity,type);
			list.add(p);
		}
		DBUtil.dbclose();
		return list;
	}

	@Override
	public List<Orders> getAllOrder(int id1) throws SQLException {
		
		List<Orders> list = new ArrayList<>();
		Connection con=DBUtil.dbConnect();
		String sql = "select * from orders where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id1);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) { 
			int pid = rst.getInt("product_id");
			int uid = rst.getInt("user_id");
			int oid = rst.getInt("orders_id");
			String pname = rst.getString("product_name");
			String uname = rst.getString("user_name");
			Orders order = new Orders(pid,uid,oid,pname,uname);
			list.add(order);
		}
		DBUtil.dbclose();
		return list;
	}

	@Override
	public void createOrder(int id, int userId, String productName, String username) throws SQLException {
		Connection con=DBUtil.dbConnect();
		String sql = "INSERT INTO orders(product_id,user_id,product_name,user_name) VALUES(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setInt(2, userId);
		pstmt.setString(3, productName);
		pstmt.setString(4,username);
		int changes=pstmt.executeUpdate();
		if(changes==0)
			System.out.println("Error....No updates have been done");
		else
			System.out.println("New Order has been placed succesfully...");
		DBUtil.dbclose();
		
	}

	@Override
	public void cancelOrder(int userid, int orderid) throws SQLException {
		Connection con=DBUtil.dbConnect();
		String sql = "delete from orders where user_id = ? AND order_id = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, userid);
		pstmt.setInt(2, orderid);
		int changes=pstmt.executeUpdate();
		if(changes==0)
			System.out.println("Error....No updates have been done");
		else
			System.out.println("Order has been deletd succesfully...");
		DBUtil.dbclose();
		
	}

	@Override
	public String checkRole(int rolecheck) throws SQLException {
		Connection con=DBUtil.dbConnect();
		String sql = "select role from user where id= ? AND role ='Admin' ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, rolecheck);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next())
		{
			return "Admin";
		}
		else
			return "User";
	}

	@Override
	public void createProduct(Product proinsertion) throws SQLException {
		
		Connection con=DBUtil.dbConnect();
		String sql = "INSERT INTO product(product_name,description,price,quantity_in_stock,type) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		String productName= proinsertion.getProductName();
		String description=proinsertion.getDescription();
		double price = proinsertion.getPrice();
		int qis= proinsertion.getQuantityInStock();
		String type=proinsertion.getType();
		pstmt.setString(1, productName);
		pstmt.setString(2, description);
		pstmt.setDouble(3, price);
		pstmt.setInt(4, qis);
		pstmt.setString(5, type);
		int changes=pstmt.executeUpdate();
		if(changes==0)
			System.out.println("Error....No updates have been done");
		else
			System.out.println("New Product has been Inserted succesfully...");
		DBUtil.dbclose();
		
	}

}
