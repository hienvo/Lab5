package clients;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import jdk.nashorn.internal.objects.Global;

public class todoClients {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		java.util.Date date= new java.util.Date();
//		new Timestamp(date.getTime());
//		
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
		//boolean loopMenu = false;
//		boolean menuInput = false;
		boolean optionInput = false;
		String timeStamp;
		String[] todo = {"",""};
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
				
				System.out.println("Enter input [id] and [todo_message]");
				
				new Timestamp(date.getTime());
				String id = sc.next();
				
				
				sc.nextLine();
				todo[0] = sc.nextLine();
										
				timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
				todo[1] = timeStamp;
				timeStamp = "";				
				
			
				
				  try {
						System.out.println("Making POST call");				
						String urlParameters  = "choice=" + choice + "&id=" + id + "&message=" + todo[0] +"&date=" + todo[1];						
						byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
						int    postDataLength = postData.length;
						String request        = "http://localhost:8080/Lab2/todoServlet";
						URL    url            = new URL( request );
						HttpURLConnection conn= (HttpURLConnection) url.openConnection();  					
						conn.setDoOutput( true );
						conn.setInstanceFollowRedirects( false );
						conn.setRequestMethod( "POST" );
						conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
						conn.setRequestProperty( "charset", "utf-8");
						conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
						conn.setUseCaches( false );			
				    try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
						   wr.write( postData );						   
						}
						BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						String next_record = null;			
						while ((next_record = reader.readLine()) != null) {
							System.out.println(next_record);
						}	
						
					} catch (IOException e) {
						throw new RuntimeException("Please try again. \n" + e);
					} 
				  
				System.out.println("                  Menu                 ");	
		    	System.out.println("1. POST[id] [todomessage] 2. GET [id] 3. GET LIST ;4. DELETE [id] 5. PUT [id] 6. Exit");	
			
		    	break;
		    
			case 2:
			
					System.out.println("GET [i]: Retrives and displays the todomessage when it was post");		
					System.out.println("Enter the id to get the message at that id");
					String id_get = sc.next();			
							try {
								String a = String.valueOf(choice);
								System.out.println("Making GET call");
								String request        = "http://localhost:8080/Lab2/todoServlet" + "?choice=" +  URLEncoder.encode(a, "UTF-8") + "&id=" + URLEncoder.encode(id_get, "UTF-8") +"&date="+ URLEncoder.encode(todo[1], "UTF-8");
								URL    url            = new URL( request );
								HttpURLConnection conn= (HttpURLConnection) url.openConnection();   
								
								conn.setInstanceFollowRedirects( false );
								conn.setRequestMethod( "GET" );
								conn.setUseCaches( false );
								
								BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
								String next_record = null;
								while ((next_record = reader.readLine()) != null) {
									System.out.println(next_record);
								}
							} catch (IOException e) {
								throw new RuntimeException("Please try again. \n" + e);
							}
							
							
						
				System.out.println("                  Menu                 ");	
		    	System.out.println("1. POST[id] [todomessage] 2. GET [id] 3. GET LIST ;4. DELETE [id] 5. PUT [id] 6. Exit");
				break;
			
			case 3:						
				    try {
				    	String a = String.valueOf(choice);
						System.out.println("Making GET call");
						String request        = "http://localhost:8080/Lab2/todoServlet" + "?choice=" +  URLEncoder.encode(a, "UTF-8");
						URL    url            = new URL( request );
						HttpURLConnection conn= (HttpURLConnection) url.openConnection();   
						
						conn.setInstanceFollowRedirects( false );
						conn.setRequestMethod( "GET" );
						conn.setUseCaches( false );
						
						BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						String next_record = null;
						while ((next_record = reader.readLine()) != null) {
							System.out.println(next_record);	
					}
							
					} catch (IOException e) {
						throw new RuntimeException("Please try again. \n" + e);
					}				
				
		
				System.out.println("                  Menu                 ");	
		    	System.out.println("1. POST[id] [todomessage] 2. GET [id] 3. GET LIST ;4. DELETE [id] 5. PUT [id] 6. Exit");
				break;
				
				
			case 4:
					System.out.println("DELETE [i] Enter id that need to remove");
					String id2 = sc.next();					
					try {
						System.out.println("Making POST call");				
						String urlParameters  = "choice=" + choice + "&id=" + id2;						
						byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
						int    postDataLength = postData.length;
						String request        = "http://localhost:8080/Lab2/todoServlet";
						URL    url            = new URL( request );
						HttpURLConnection conn= (HttpURLConnection) url.openConnection();  					
						conn.setDoOutput( true );
						conn.setInstanceFollowRedirects( false );
						conn.setRequestMethod( "POST" );
						conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
						conn.setRequestProperty( "charset", "utf-8");
						conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
						conn.setUseCaches( false );			
				    try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
						   wr.write( postData );						   
						}
						BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						String next_record = null;			
						while ((next_record = reader.readLine()) != null) {
							System.out.println(next_record);
						}	
						
					} catch (IOException e) {
						throw new RuntimeException("Please try again. \n" + e);
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

					try {
						System.out.println("Making POST call");				
						String urlParameters  = "choice=" + choice + "&id=" + id_put + "&message=" + todo_put[0] + "&date=" + todo_put[1];						
						byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
						int    postDataLength = postData.length;
						String request        = "http://localhost:8080/Lab2/todoServlet";
						URL    url            = new URL( request );
						HttpURLConnection conn= (HttpURLConnection) url.openConnection();  					
						conn.setDoOutput( true );
						conn.setInstanceFollowRedirects( false );
						conn.setRequestMethod( "POST" );
						conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
						conn.setRequestProperty( "charset", "utf-8");
						conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
						conn.setUseCaches( false );			
				    try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
						   wr.write( postData );						   
						}
						BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						String next_record = null;			
						while ((next_record = reader.readLine()) != null) {
							System.out.println(next_record);
						}	
						
					} catch (IOException e) {
						throw new RuntimeException("Please try again. \n" + e);
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
	}
}
