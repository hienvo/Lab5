package clients;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;


import model.Customer;
import model.Room;
import model.Transaction;

public class HotelReservationClient {

	public MysqlConnector connector;

	public HotelReservationClient(Scanner s, String dbName){
		connector = new MysqlConnector(s, dbName);
		Connection conn = connector.getConnection();
		connector.createDB(conn, dbName);
		connector.createTable(conn);
	}

	public HotelReservationClient(Scanner s, String dbName, String user, String pass){
		connector = new MysqlConnector(s, dbName, user, pass);
		Connection conn = connector.getConnection();
		connector.createDB(conn, dbName);
		connector.createTable(conn);
	}

	
	public static void main(String args[]) {

		//Read from Servlet
		try {
			System.out.println("Making GET call");
			String request        = "http://localhost:8080/PA1/Reservations";
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
		
		
		try {
			System.out.println("Making POST call");
			// Parse the URL
			String urlParameters  = "param1=a&param2=b&param3=c";
			byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
			int    postDataLength = postData.length;
			String request        = "http://localhost:8080/PA1/Reservations";
			URL    url            = new URL( request );
			HttpURLConnection conn= (HttpURLConnection) url.openConnection();   
			
			conn.setDoOutput( true );
			conn.setInstanceFollowRedirects( false );
			conn.setRequestMethod( "POST" );
			conn.setRequestProperty( "Content-Type", "text/html"); 
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
		
		//old code
		Scanner s = new Scanner(System.in);  // Reading from System.in
		String dbName = "Lab1";
		HotelReservationClient client = new HotelReservationClient(s, dbName);
		MysqlConnector conn = client.connector;
		String username = conn.getUser();
		String password = conn.getPassword();
		int choice = 0;
		boolean again = true;
		do {
			try {
				System.out.print("\n" + "Choose one of the following options: " + "\n"
						+ "(1) POST [id] [todo message]" + "\n"
						+ "(2) GET [id]" + "\n"
						+ "(3) GET" + "\n"
						+ "(4) DELETE [id] " + "\n"
						+ "(5) REPLICATE [URI]" + "\n"
						+ "(6) EXIT PROGRAM" + "\n" + "\n"
						+ "Please enter a number:  ");
				try {
					choice = Integer.parseInt(s.nextLine());
				}catch(NumberFormatException nfe){
					System.err.println("Invalid Format!");
				}
				System.out.println();
				switch (choice) {
				case 1: 
					// Insert an ToDo item.
					System.out.print("Enter an id number: ");
					int id = Integer.parseInt(s.nextLine());
					System.out.print("Enter a message: ");
					String message = s.nextLine();
					Room insertToDo = new Room();
					insertToDo.setId(id);
					insertToDo.setToDoMessage(message);
					insertToDo.setTimestamp();
					boolean success = conn.insertToDo(insertToDo);
					if(!success){
						System.err.println("Insert failed");
					}else{
						System.out.println("Insert success!");
					}
					break;
				case 2:
					// Get and display todo message as well as when it was posted.
					System.out.print("\n" + "Enter a ToDo id number: ");
					int todoId = Integer.parseInt(s.nextLine());
					Room todo = conn.getToDoMessage(todoId);
					System.out.println("\n" + "Displaying record...");

					//Retrieve row data
					int get_id  = todo.getId();
					String get_message = todo.getMessage();
					Timestamp get_time = todo.getTimestamp();

					//Display values
					System.out.println("id: 			" + get_id);
					System.out.println("message: 		" + get_message);
					System.out.println("date posted: 		" + get_time + "\n");
					break;
				case 3:
					//Get and display all todo items
					List<Room> todos = conn.getAllMessages();
					System.out.println("Displaying all records...");
					for(Room todo1 : todos){
						//Retrieve row data
						int all_ids  = todo1.getId();
						String all_messages = todo1.getMessage();
						Timestamp all_times = todo1.getTimestamp();

						//Display values
						System.out.println("id: 			" + all_ids);
						System.out.println("message:		" + all_messages);
						System.out.println("date posted: 	" + all_times + "\n");
					};
					break;
				case 4:
					// Deletes the todo message at the given id from the database.
					System.out.print("Enter an id number: ");
					int deleteId = Integer.parseInt(s.nextLine());
					boolean todoDelete = conn.deleteMessage(deleteId);
					if(!todoDelete){
						System.err.println("Delete failed");
					}else{
						System.out.println("Delete success!");
					};
					break;
				case 5:
					// replicate database and table
					System.out.print("Enter the URI (in [host]/[database] format) : ");
					String uri = s.nextLine();
					String delims = "[/]";
					String[] tokens = uri.split(delims);
					String old_dbName = dbName;
					dbName = tokens[1];
					System.out.println();
					// get all data from todo
					List<Room> copy_todos = conn.getAllMessages();
					HotelReservationClient new_client = new HotelReservationClient(s, dbName, username, password);
					MysqlConnector new_conn = new_client.connector;
					boolean replicate_success = false;
					// for each todo returned, insert it into the new table
					for(Room new_todo : copy_todos){
						//Retrieve row data
						int all_ids  = new_todo.getId();
						String all_messages = new_todo.getMessage();
						Timestamp all_times = new_todo.getTimestamp();
						Room insert_copy = new Room();
						insert_copy.setId(all_ids);
						insert_copy.setToDoMessage(all_messages);
						insert_copy.setTimestamp(all_times);
						replicate_success = new_conn.insertToDo(insert_copy);
						//Display replicated values
						System.out.println("id: 			" + all_ids);
						System.out.println("message:		" + all_messages);
						System.out.println("date posted: 	" + all_times + "\n");
					};
					if(!replicate_success){
						System.err.println("Replication failed");
					}else{
						System.out.println("Replication success!");
					};
					// return to old client
					HotelReservationClient old_client = new HotelReservationClient(s, old_dbName, username, password);
					conn = old_client.connector;
					break;
				case 6:
					// exit program
					System.out.println("Goodbye!");
					again = false;
				};
			} catch (Exception e) {
				System.out.println("That is not a valid entry.");
				//TODO Auto-generated catch block
				e.printStackTrace();

			};
		} while (again == true);
	}

}
