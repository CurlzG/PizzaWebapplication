

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import orders.Orders;
import jakarta.servlet.http.*;
/**
 * Servlet implementation class TestSerlvet
 */
public class TestSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public List<Orders> listOrders;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSerlvet() {
        super();
        listOrders = new ArrayList<Orders>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = null;
		Driver drive = new Driver();
		//Declaring Variables
		String Name = String.valueOf(request.getParameter("Name"));
		String Base = String.valueOf(request.getParameter("Base"));
		String Size = String.valueOf(request.getParameter("Size"));
		String top1 = String.valueOf(request.getParameter("top1")) == "null" ? "Nothing" : String.valueOf(request.getParameter("top1"));
		String top2 = String.valueOf(request.getParameter("top2")) == "null" ? "Nothing" : String.valueOf(request.getParameter("top2"));
		String top3 = String.valueOf(request.getParameter("top3")) == "null" ? "Nothing" : String.valueOf(request.getParameter("top3"));
		String Address = String.valueOf(request.getParameter("Address"));
		if(request.getParameter("AddPizza") != null) {
			//Creating Class Object to hold the values
			Orders order = new Orders(Name,Base,Size,top1,top2,top3,Address);
			System.out.println(order.toString());
			if(listOrders.size() == 0 && order.Name != "" && order.Address != "") {
				listOrders.add(order);
				request.setAttribute("Warning", "");
			}else if(listOrders.size() > 0 && Base != "null" && Size != "null") {
				request.setAttribute("Warning", "");
				listOrders.add(order);
			} else {
				if(Base == "null" || Size == "null" ) {
					request.setAttribute("Warning", "No Base Or Size Were Entered");
				} else {
					request.setAttribute("Warning", "No Values Were Entered");
				}
				
				//System.out.println("Value Empty");
			}
			request.setAttribute("listOrders", listOrders);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} else {
			System.out.println("NOPE");
			String orderName  = listOrders.get(0).Name;
			String orderAddress  = listOrders.get(0).Address;
			for(int i = 0; i < listOrders.size(); i++) {
				
				if(listOrders.get(i).Name == "null") {
					listOrders.get(i).Name = orderName;
				}
				if(listOrders.get(i).Address == "null") {
					listOrders.get(i).Address = orderAddress;
				}
				System.out.println(listOrders.get(i));
				try {
					drive.addRes(listOrders.get(i), listOrders.size());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		//doGet(request, response);
	}

}
