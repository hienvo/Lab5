

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import javax.servlet.Filter;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/")
public class TodoServlet  {
	
	ConcurrentHashMap<String, String> myMessage = new ConcurrentHashMap<String, String>();
		
	@POST
	@Consumes({ MediaType.TEXT_PLAIN })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/todo/create")
	public Response createTodoMessage(@FormParam("id") String id, @FormParam("message") String message)
	{
//		String id3 = request.getParameter("id");
//		String message2 = request.getParameter("message");
		// String date2 = request.getParameter("date");
		boolean flag2 = false;
		if (!myMessage.isEmpty()) {
			for (String key : myMessage.keySet()) {
				if (id.equals(key)) {
//					out.println("ID is already here, overwrite it! Enter Successfully!");
					myMessage.replace(id, message);
					flag2 = true;
					break;
				}
			}
				if (flag2 == false) {
//					out.println("ID is not here, put it! Enter Successfully!");
					myMessage.put(id, message);
				}			
		} else {
//			out.println("ConcurrentHashMap is empty, PUT it!" + "\n" + "Enter Successfully!");
			myMessage.put(id, message);
		}		
		String json = "";
		try {
			json = new ObjectMapper().writeValueAsString(myMessage);
		} catch (Exception e) {
			return Response.status(500).build();
		}
		
		return Response.ok(json,"application/json").build();
	}


//	@GET
//	@Consumes({ MediaType.TEXT_PLAIN })
//	@Produces({ MediaType.APPLICATION_JSON })
//	@Path("/todo/view/xml/{id: [0-9]+}")
//	public Response getXMLMessage() {
//		String id = request.getParameter("id");
//		if (!myMessage.isEmpty()) {
//			boolean flag = false;
//			for (String key : myMessage.keySet()) {
//				if (id.equals(key)) {
//					String output = "id: " + id + " mesage: " + myMessage.get(id);
//					out.println(output);
//					flag = true;
//					break;
//				}
//			}
//			if (flag == false) {
//				out.println("Error: Invalid ID");
//			}
//		} else {
//			out.println("Error: ConcurrentHashMap is empty!");
//		}
//	}
//
//	@GET
//	@Produces({ MediaType.APPLICATION_JSON })
//	@Path("/todo/view/json")
//	public Response getJsonMessage() {
//		String a = myMessage.toString();
//		if (!myMessage.isEmpty()) {
//			out.println(a);
//		} else {
//			out.println("Error: concurrentHashMap is empty!");
//		}
//	}
//
//	@POST
//	@Consumes({ MediaType.TEXT_PLAIN })
//	@Produces({ MediaType.APPLICATION_JSON })
//	@Path("/todo/delete")
//	public Response deleteTodo() {
//		String id2 = request.getParameter("id");
//		boolean flag3 = false;
//		if (!myMessage.isEmpty() && flag3 == false) {
//			for (String key : myMessage.keySet()) {
//				if (id2.equals(key)) {
//					myMessage.remove(id2);
//					out.println("Remove successfully");
//					flag3 = true;
//					break;
//				}
//			}
//			if (flag3 == false) {
//				out.println("Error: invalid id");
//			}
//
//		} else {
//			out.println("Empty ConcurrentHashMap");
//		}
//		break;
//	}
}
