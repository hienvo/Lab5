package clients;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class todoClients {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		boolean optionInput = false;
		System.out.println("                  Menu                 ");		
		System.out.println("Enter your option: ");
		System.out.println("1. POST[id] [todomessage] ");
		System.out.println("2. GET [id]");
		System.out.println("3. GET LIST");
		System.out.println("4. DELETE [id]");
		System.out.println("5. PUT [id]");
		System.out.println("6. Exit");
	
		
		while(!optionInput)
		{
			int choice = sc.nextInt();
			switch (choice) {
		
			case 1: 
				
				System.out.println("Enter input [i]");
				
				String id = sc.next();
				
				System.out.println("and [todo_message]");
				String todo;
				sc.nextLine();
				todo = sc.nextLine();
										

				try {
					System.out.println("Making POST call");				
					String urlParameters  = "choice=" + choice + "&id=" + id + "&message=" + todo;
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
							
			    break;
			case 2:
			
					System.out.println("GET [i]: Retrives and displays the todomessage when it was post");		
					System.out.println("Enter the id to get the message at that id");
					String id_get = sc.next();			
					try {
						
						System.out.println("Making GET call");
						String request        = "http://localhost:8080/Lab2/todoServlet" + "&choice=" + choice + "&id_get=" + id_get;
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
					break;
			
			case 3:
				
				System.out.println("GET LIST: Display all the IDs and messages");						
				try {
					System.out.println("Making GET call");
					String request        = "http://localhost:8080/Lab2/todoServlet" + "&choice=" + choice;
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
				break;
				
				
			case 4:
				
					System.out.println("DELETE [i] Enter id that need to remove");
					
				
					String id2 = sc.next();
					
					try {
						System.out.println("<Making POST call>");
				
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
					break;
			case 5: 
				
					System.out.println("PUT [id]");
					System.out.println("Enter input [i] and [todo_message]");
					
					

					String id_put = sc.next();
					
					String[] todo_put = {"",""};
					sc.nextLine();
					todo_put[0] = sc.nextLine();
															
					try {
						System.out.println("<Making POST call>");
						String urlParameters  = "choice=" + choice + "&id=" + id_put + "&putMessage=" + todo_put[0];
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
	

