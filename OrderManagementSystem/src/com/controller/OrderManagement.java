package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.UserNotFoundException;
import com.model.Orders;
import com.model.Product;
import com.model.User;
import com.service.OrderProcessorService;

public class OrderManagement {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	OrderProcessorService orderService = new OrderProcessorService();
	
	while (true) {
		System.out.println("------------------Order Management--------------------");
		System.out.println("Press 1.  create an order");
		System.out.println("Press 2.  cancel an order");
		System.out.println("Press 3.  create a product");
		System.out.println("Press 4.  create a user");
		System.out.println("Press 5.  Get all product details");
		System.out.println("Press 6.  Get all order details of a particular user by id");
		System.out.println("Press 0.  EXIT");
		int input = sc.nextInt();
		
		if (input == 0) {
			System.out.println("Exiting Order Management.......THANK YOU!!!!");
			break;
		}
		switch (input) {
		case 1:
			System.out.println("-------Creating Your Order-------");
			System.out.println("Enter User id: ");
			sc.nextLine();
			int userId = sc.nextInt();
			System.out.println("Enter Product id: ");
			int id = sc.nextInt();
			System.out.println("Enter product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Enter user name:");
			String username = sc.nextLine();
			
			try {
				orderService.createOrder(userId, id, productName, username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			System.out.println("========Order Cancellation========");
			System.out.println("Enter user ID: ");
			int userid = sc.nextInt();
			System.out.println("Enter Order ID: ");
			int orderid = sc.nextInt();
			
			try {
				orderService.cancelOrder(userid, orderid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 3:
			try {
			System.out.println("==========Create Product========");
			System.out.println("Enter the user ID: ");
			int rolecheck = sc.nextInt();
			String role = orderService.checkRole(rolecheck);
			if (role.equals("Admin")) {
				System.out.println("YOU Can create Product");
				Random random = new Random(); 
				int randomNumber = random.nextInt(); 
				int productid =randomNumber<0?randomNumber*-1:randomNumber; 
				System.out.println("Enter the product Name: ");
				sc.nextLine();
				String pname = sc.nextLine();
				System.out.println("Enter the product Description: ");
				String pdescribe = sc.nextLine();
				System.out.println("Enter the product Price: ");
				double pprice = sc.nextDouble();
				System.out.println("Enter the product Quantity in Stock: ");
				int pqos = sc.nextInt();
				System.out.println("Enter the product Type (Electronic/Clothing): ");
				sc.nextLine();
				String ptype = sc.nextLine();
				
				Product proinsertion = new Product(productid,pname,pdescribe,pprice,pqos,ptype);
					orderService.createProduct(proinsertion);
			} else
				System.out.println("User who are not admin cannot add Products");
			} catch (SQLException e) {}
			break;
			
		case 4:
			System.out.println("==========Create A user=========");
			Random random = new Random(); 
			int randomNumber = random.nextInt(); 
			int Userid =randomNumber<0?randomNumber*-1:randomNumber; 
			System.out.println("Enter your new Username: ");
			sc.nextLine();
			String userName = sc.nextLine();
			System.out.println("Enter your new Password: ");
			String password = sc.nextLine();
			String roles = "User";
			User user = new User(Userid,userName, password, roles);
			try {
				orderService.createUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			try {
			System.out.println("============Display All Product Details========");
				List<Product>list = orderService.getAllProducts();
				for (Product p : list)
				System.out.println(p);
			} catch (SQLException e) {
			}
			break;
			
		case 6:
			try {
			System.out.println("==========Order Details By ID=========");
			System.out.println("Enter your ID: ");
			int id1= sc.nextInt();
			List<Orders> uid = orderService.getAllOrder(id1);
			for (Orders o : uid)
				System.out.println(o);
			} catch (SQLException e) {}
			break;
			
		default:
			System.out.println("Invalid Choice");
			break;




}
	}
	}
}