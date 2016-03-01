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
@WebServlet(name = "MyOwnServlet",
description = "This is my first annotated servlet",
urlPatterns = {"/todoServlet","/todoS"})
public class todoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Scanner sc = new Scanner(System.in);
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String message;
	
    public todoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		java.util.Date date= new java.util.Date();
//		new Timestamp(date.getTime());
//		
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
		//boolean loopMenu = false;
//		boolean menuInput = false;
		boolean optionInput = false;
		String timeStamp;
		System.out.println("                  Menu                 ");		
		System.out.println("Enter your option: ");
		System.out.println("1. POST[id] [todomessage] ");
		System.out.println("2. GET [id]");
		System.out.println("3. GET LIST");
		System.out.println("4. DELETE [id]");
		System.out.println("5. PUT [id]");
		System.out.println("6. Exit");
		
		
		ConcurrentHashMap<String, String[]> myMessage;
		myMessage = new ConcurrentHashMap<String, String[]>();
		while(!optionInput)
		{
			int choice = sc.nextInt();
			switch (choice) {
		
			case 1: 
				System.out.println("Enter input [i] and [todo_message]");
				
				new Timestamp(date.getTime());
				String id = sc.next();
				
				String[] todo = {"",""};
				sc.nextLine();
				todo[0] = sc.nextLine();
										
				timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
				todo[1] = timeStamp;
				timeStamp = "";
//				myMessage = new ConcurrentHashMap<String, String>();
				
				
				boolean flag = false;
				for ( String key : myMessage.keySet() ) {
					if (id.equals(key) ){
						flag = true;
						break;
					}
				}
				if (flag == false){
			    	myMessage.put(id, todo);
			    	System.out.println("Enter successful");
			    	System.out.println("                  Menu                 ");	
			    	System.out.println("1. POST[id] [todomessage] 2. GET [id] 3. GET LIST ;4. DELETE [id] 5. PUT [id] 6. Exit");
			    }
			    else {
			    	
			    	System.out.println("Error: ID is already have");
			    	optionInput=true;
			    	break;
			    }
				
//				response.setContentType("text/html");
//				PrintWriter out = response.getWriter();
//			    out.println("<h1>" + myMessage +" "+ date + "</h1>");
			    
	//		    String param = request.getParameter("param3");
	//		    doGet(request,response);
			    break;
		    
			case 2:
				if(!myMessage.isEmpty())
				{
					System.out.println("GET [i]: Retrives and displays the todomessage when it was post");		
					System.out.println("Enter the id to get the message at that id");
					String id_get = sc.next();			
					String[] temp_get={"",""};
					
					flag = false;
					for (String key : myMessage.keySet() ) {
						temp_get = myMessage.get(key);
						if(id_get.equals(key))
						{
							System.out.println(" ID: " + key +" Message: "+ temp_get[0] +" Date: "+ temp_get[1]);				
							flag = true;
							break;
						}
														
					}		
					
					if (flag == false) {
						System.out.println("Invalid ID");
					}
				}
				else
				{
					System.out.println("concurrentHashMap is empty!");
				}
				System.out.println("                  Menu                 ");	
		    	System.out.println("1. POST[id] [todomessage] 2. GET [id] 3. GET LIST ;4. DELETE [id] 5. PUT [id] 6. Exit");
				break;
			
			case 3:
				
				System.out.println("GET LIST: Display all the IDs and messages");						
				String[] temp={"",""};
				List<String> tempList = new ArrayList<String>();
				int count = 0;
				for ( String key : myMessage.keySet() ) {
				    temp = myMessage.get(key);
				    tempList.add(temp[0]);
				    System.out.println(" ID: " + key +" todoMessage: " + tempList.get(count));				    
				    count=count+1;
				}
				System.out.println("                  Menu                 ");	
		    	System.out.println("1. POST[id] [todomessage] 2. GET [id] 3. GET LIST ;4. DELETE [id] 5. PUT [id] 6. Exit");
				break;
				
				
			case 4:
				if(!myMessage.isEmpty())
				{
					System.out.println("DELETE [i] Enter id that need to remove");
					
					//boolean checkInput = true;
					String id2 = sc.next();
					
					for ( String key : myMessage.keySet() ) {
						if (id2.equals(key) ){
							myMessage.remove(id2);
							break;
						}
						else
						{
							System.out.println("Error: invalid id");
							break;
						}
					}									

				}
				else {
					System.out.println("Empty ConcurrentHashMap");

				}
				System.out.println("                  Menu                 ");	
		    	System.out.println("1. POST[id] [todomessage] 2. GET [id] 3. GET LIST ;4. DELETE [id] 5. PUT [id] 6. Exit");
					break;
			case 5: 
				
					System.out.println("PUT [id]");
					System.out.println("Enter input [i] and [todo_message]");
					
					
					new Timestamp(date.getTime());
					String id_put = sc.next();
					
					String[] todo_put = {"",""};
					sc.nextLine();
					todo_put[0] = sc.nextLine();
											
					timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
					todo_put[1] = timeStamp;
					timeStamp = "";
//					myMessage = new ConcurrentHashMap<String, String>();
					
					if(!myMessage.isEmpty())
					{
					for ( String key : myMessage.keySet() ) {
						if (id_put.equals(key)) {
							System.out.println("ID is available, overwrite it!");
							myMessage.replace(id_put, todo_put);
							
						}						
						else {
							System.out.println("ID is not available, put it!");
							myMessage.put(id_put, todo_put);
						}
					}
					}
					else 
					{
						System.out.println("ConcurrentHashMap is empty, put it!");
						myMessage.put(id_put, todo_put);
						
					}
					System.out.println("                  Menu                 ");	
			    	System.out.println("1. POST[id] [todomessage] 2. GET [id] 3. GET LIST ;4. DELETE [id] 5. PUT [id] 6. Exit");
	
					break;
					
			case 6: 
				System.out.println("Exit");
					optionInput=true;
					break;
			default:
				System.out.println("Invalid Selection");
				break;
			
			}
	
		}
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String[] temp={"",""};
		for ( String key : myMessage.keySet() ) {
		    System.out.println( key );
		    temp = myMessage.get(key);
		    out.println("<h1>" + key +" "+ temp[0] +" "+ temp[1] + "</h1>");
		}
		
	    
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param3");
		doGet(request,response);
		
	}

}
