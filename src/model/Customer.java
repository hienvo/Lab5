package model;
import java.sql.Timestamp;
import java.util.Calendar;

public class Customer {

	private int id;
	private String todo_message;
	private Timestamp timestamp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return todo_message;
	}
	public void setToDoMessage(String todo_message) {
		this.todo_message = todo_message;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp() {
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();
		 
		// 2) get a java.util.Date from the calendar instance.
		//    this date will represent the current instant, or "now".
		java.util.Date now = calendar.getTime();
		 
		// 3) a java current time (now) instance
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		this.timestamp = currentTimestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
