import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDateTime;

import orders.DeliveryOrder;
import orders.Orders;
public class Driver {
	
	public Connection myConn;
	public Statement myStmt;
	public ResultSet myRes;
	
	//Constructor Method
	//For Creating the sql calls
	public Driver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzalife","","");
			myStmt = myConn.createStatement();
			
		
			
		}catch(Exception e) {
			System.out.println("ERROR " + e);
		}
	}
	//Get Results, allowing for quick, SQL queries
	public ArrayList<Orders> getRes() throws SQLException {
		ArrayList<Orders> totalOrder = new ArrayList<Orders>();
		myRes = myStmt.executeQuery("SELECT" + " * " + "from " + " pizzalife.orders");
		while(myRes.next()) {
			Orders order = new Orders(myRes.getString("name"),myRes.getString("base"),myRes.getString("size"),myRes.getString("topping1"),myRes.getString("topping2"),myRes.getString("topping3"),myRes.getString("address"));
			totalOrder.add(order);
		}
		return totalOrder;
	}
	//Adds new Orders into the Database
	public void addRes(Orders order, int quanity) throws SQLException {
		myRes = myStmt.executeQuery("SELECT MAX(order_num) from pizzalife.orders");
		myRes.next(); //Moves the Pointer and Stops the Error accuring
		int length = Integer.parseInt(myRes.getString("MAX(order_num)"));
		length++; // making sure that order_num doesn't equal the same
		java.util.Date date = new java.util.Date();    
		String query = "insert into pizzalife.orders" + "(order_num,name, base, size, topping1,topping2,topping3, address,quanity,timeplace)" + "values (" + length+ ",'" + order.Name + "','" + order.Base + "','" +order.Size + "','" + order.top1 + "','" + order.top2 + "','" + order.top3 + "','" + order.Address +"','"+quanity+"','"+date+"')";
	    myStmt.executeUpdate(query);
	}
	//Creating Delivery Orders from the orders Database
	public ArrayList<DeliveryOrder> getDeliv() throws SQLException {
		ArrayList<DeliveryOrder> totalOrder = new ArrayList<DeliveryOrder>();
		myRes = myStmt.executeQuery("SELECT" + " * " + "from " + " pizzalife.orders");
		while(myRes.next()) {
			DeliveryOrder order = new DeliveryOrder(Integer.parseInt(myRes.getString("order_num")),myRes.getString("name"),myRes.getString("address"));
			totalOrder.add(order);
		}
		return totalOrder;
	}
}
