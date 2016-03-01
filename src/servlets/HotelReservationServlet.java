package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import servlets.MysqlConnector;


/**
 * Servlet implementation class EchoServlet
 */
@WebServlet(name = "HotelReservationServlet",
description = "This is my first annotated servlet",
urlPatterns = {"/Reservations"})
public class HotelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public HotelReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException
    {
    	//Scanner s = new Scanner(System.in);  // Reading from System.in
		String dbName = "Hotel_Reservation_System";
    	MysqlConnector connector;
    	connector = new MysqlConnector(dbName);
		Connection conn = connector.getConnection();
		connector.createDB(conn, dbName);
		connector.createTables(conn, "customers", "rooms", "transactions");
		//String username = ((MysqlConnector) conn).getUser();
		//String password = ((MysqlConnector) conn).getPassword();

        // Do required initialization
    	
    };

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Scanner s = new Scanner(System.in);  // Reading from System.in
		String dbName = "Hotel_Reservation_System";
    	MysqlConnector connector;
    	connector = new MysqlConnector(dbName);
		//Connection conn = connector.getConnection();
		
		try {
			Integer choice = Integer.parseInt(request.getParameter("choice"));
			
			switch (choice) {
			case 1: 
				String first_name = request.getParameter("first_name");
				String last_name = request.getParameter("last_name");
				String phone_number = request.getParameter("phone_number");
				String billing_address = request.getParameter("billing_address");
				String billing_city = request.getParameter("billing_city");
				String billing_state = request.getParameter("billing_state");
				String billing_zip = request.getParameter("billing_zip");
				String checkin_date = request.getParameter("checkin_date");
				String checkout_date = request.getParameter("checkout_date"); 
				Customer insertCustomer = new Customer();
				insertCustomer.setName(first_name, last_name);
				insertCustomer.setNumber(Integer.parseInt(phone_number));
				insertCustomer.setBillingInfo(billing_address, billing_city,
						billing_state, Integer.parseInt(billing_zip));
				insertCustomer.setCheckInOut(checkin_date, checkout_date);
				boolean success = connector.insertCustomer(insertCustomer);
				int id = insertCustomer.getId();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				if(!success){
				      out.println("<h1>" + "Error!" + "</h1>");
				}else{
				      out.println("<h1>" + "Customer id: " + id + "</h1>");
				      break;
				}
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			};
		} catch (Exception e) {
			System.out.println("That is not a valid entry.");
			//TODO Auto-generated catch block
			e.printStackTrace();

		};

	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param2");
		doGet(request,response);
		
	}
*/
}
