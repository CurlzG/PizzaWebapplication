

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import orders.DeliveryOrder;
import orders.Orders;
/**
 * Servlet implementation class DeliverySerlvet
 */
public class DeliverySerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliverySerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Driver drive = new Driver();
		if(request.getParameter("getOrder") != null) {
		Map<DeliveryOrder, ArrayList<Integer>> map = new HashMap<>();
		try {
			ArrayList<DeliveryOrder> total = drive.getDeliv();
			for(int i = 0; i < total.size();i++ ) {
				int count = 0; 
				ArrayList<Integer> temp = new ArrayList<Integer>();
				while(count != total.size()) {
					if(total.get(i).name.equals(total.get(count).name) && total.get(i).address.equals(total.get(count).address) ) {
						temp.add(total.get(count).num);
					}
					count++; 
				}
				if(!map.containsValue(temp)) {
					map.put(total.get(i),temp);
				}
		
				}
			
			request.setAttribute("map", map);
			//request.setAttribute("totalOrders", total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			//for(int i = 0; i < )
		}
		
		request.getRequestDispatcher("delivery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
