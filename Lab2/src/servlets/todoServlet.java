package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/**
 * Servlet implementation class EchoServlet
 */
@WebServlet(name = "MyOwnServlet", description = "This is my first annotated servlet", urlPatterns = { "/todoServlet",
		"/todoS" })
public class todoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ConcurrentHashMap<String, String> myMessage = new ConcurrentHashMap<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public todoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		// Do required initialization

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer choice = Integer.parseInt(request.getParameter("choice"));
		PrintWriter out = response.getWriter();
		{
			switch (choice) {

			case 2:

				String id = request.getParameter("id");
				String date = request.getParameter("date");

				if (!myMessage.isEmpty()) {
					boolean flag = false;
					for (String key : myMessage.keySet()) {
						if (id.equals(key)) {
							out.println("id: " + id + " mesage: " + myMessage.get(id) + " date: " + date);
							flag = true;
							break;
						}
					}
					if (flag == false) {
						out.println("Invalid ID");
					}
				} else {
					out.println("concurrentHashMap is empty!");
				}

				break;

			case 3:
				out.println(myMessage);
				break;
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer choice = Integer.parseInt(request.getParameter("choice"));
		PrintWriter out = response.getWriter();

		switch (choice) {

		case 1:

			String id = request.getParameter("id");
			String message = request.getParameter("message");
			boolean flag = false;
			for (String key : myMessage.keySet()) {
				if (id.equals(key)) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				myMessage.put(id, message);
				out.println("Enter successful");
			}

			else {
				out.println("Error: ID is already have");
				break;
			}
			// myMessage.put(id, message);
			break;

		case 4:

			String id2 = request.getParameter("id");
			if (!myMessage.isEmpty()) {
				for (String key : myMessage.keySet()) {
					if (id2.equals(key)) {
						myMessage.remove(id2);
						out.println("Remove successful");
						break;
					} else {
						out.println("Error: invalid id");
						break;
					}
				}

			} else {
				out.println("Empty ConcurrentHashMap");

			}
			break;
		case 5:

			String id3 = request.getParameter("id");
			String message2 = request.getParameter("message");
			// String date2 = request.getParameter("date");
			if (!myMessage.isEmpty()) {

				for (String key : myMessage.keySet()) {	
				boolean flag2 = false;
					if (id3.equals(key)) {
						out.println("ID is available, overwrite it!");
						myMessage.replace(id3, message2);
						flag2 = true;
						break;
					}					
					if(flag2 = true) {
						out.println("ID is not available, PUT it!");
						myMessage.put(id3, message2);
						break;
					}
				}
			} else {
				out.println("ConcurrentHashMap is empty, PUT it!");
				myMessage.put(id3, message2);

			}

			break;

		case 6:
			out.println("Exit");
			System.exit(0);
			break;
		default:
			out.println("Invalid Selection");
			break;
		}

	}
}
