package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class EchoServlet
 */
// @WebServlet(name = "MyOwnServlet", description = "This is my first annotated
// servlet",
// urlPatterns = { "/TodoServlet"})
@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ConcurrentHashMap<String, String> myMessage = new ConcurrentHashMap<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public TodoServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		Integer choice = Integer.parseInt(request.getParameter("choice"));
		PrintWriter out = response.getWriter();

		{
			switch (choice) {

			case 2:
				String id = request.getParameter("id");
				// String date = request.getParameter("date");

				if (!myMessage.isEmpty()) {
					boolean flag = false;
					for (String key : myMessage.keySet()) {
						if (id.equals(key)) {
							String output = "id: " + id + " mesage: " + myMessage.get(id);
							out.println(output);
							flag = true;
							break;
						}
					}
					if (flag == false) {
						out.println("Error: Invalid ID");
					}
				} else {
					out.println("Error: ConcurrentHashMap is empty!");
				}

				break;

			case 3:
				String a = myMessage.toString();
				if (!myMessage.isEmpty()) {
					out.println(a);
				} else {
					out.println("Error: concurrentHashMap is empty!");
				}
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
		response.setContentType("text/html;charset=UTF-8");
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
			boolean flag3 = false;
			if (!myMessage.isEmpty()&& flag3== false) {		
				for (String key : myMessage.keySet()) {
					if (id2.equals(key)) {
						myMessage.remove(id2);
						out.println("Remove successfully");
						flag3 = true;
						break;
					}
				}
					if (flag3 == false) {
						out.println("Error: invalid id");
					}
				
			} else {
				out.println("Empty ConcurrentHashMap");
				}
			
			break;
		case 5:
			String id3 = request.getParameter("id");
			String message2 = request.getParameter("message");
			// String date2 = request.getParameter("date");
			boolean flag2 = false;
			if (!myMessage.isEmpty()) {
				for (String key : myMessage.keySet()) {
					if (id3.equals(key)) {
						out.println("ID is already here, overwrite it! Enter Successfully!");
						myMessage.replace(id3, message2);
						flag2 = true;
						break;
					}
				}
					if (flag2 == false) {
						out.println("ID is not here, put it! Enter Successfully!");
						myMessage.put(id3, message2);
						break;
					}
				
			} else {
				out.println("ConcurrentHashMap is empty, PUT it!" + "\n" + "Enter Successfully!");
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
