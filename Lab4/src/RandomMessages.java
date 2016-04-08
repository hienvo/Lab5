import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

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
import javax.xml.namespace.QName;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/")
public class RandomMessages {
	ConcurrentHashMap<String, String> myMessage = new ConcurrentHashMap<String, String>();
	
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/create")
	public Response createTodoMessage(@FormParam("id") String id, @FormParam("message") String message)
	{
		System.out.println(id);
		System.out.println(message);
		boolean flag2 = false;
		if (!myMessage.isEmpty()) {
			for (String key : myMessage.keySet()) {
				if (id.equals(key)) {
					myMessage.replace(id, message);
					flag2 = true;
					break;
				}
			}
				if (flag2 == false) {
					myMessage.put(id, message);
				}			
		} else {
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
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/xml/{id}")
	public Response getXMLMessage(@PathParam("id2") String id) {
		System.out.println("id: " +id);
		ServerResponse response = new ServerResponse();
		if (!myMessage.isEmpty()) {
			boolean flag = false;
			for (String key : myMessage.keySet()) {
				if (id.equals(key)) {
					try{
					
					String abc = myMessage.get(id);
					response.setId(id);
					response.setMessage(abc);
					return Response.ok(response,"application/xml").build();
					}
					catch(Exception e){
						return Response.status(500).build();
					}			
				}
				flag = true;
				break;
			}
			if (flag == false) {
				Response.status(404);
			}
		} else {
			Response.status(404);
		}
		try{
			return Response.ok(myMessage,"application/xml").build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}
	
	@GET
//	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.APPLICATION_JSON })
	@Path("/json")
	public Response getJsonMessage() {
		String a = myMessage.toString();
		System.out.println(a);
		String json = "";
		if (!myMessage.isEmpty()) {		
			try {
				json = new ObjectMapper().writeValueAsString(a);
				return Response.ok(json,"application/json").build();
			} catch (Exception e) {
				return Response.status(500).build();
			}
		} else {
			return Response.status(404).build();
		}
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/delete")
	public Response deleteTodo(@FormParam("id3") String id2) {
		String json="";
		boolean flag3 = false;
		if (!myMessage.isEmpty() && flag3 == false) {
			for (String key : myMessage.keySet()) {
				if (id2.equals(key)) {
					myMessage.remove(id2);				
				}
				flag3 = true;
				break;
			}
			
			if (flag3 == false) {
				return Response.status(404).build();
			}

		} else {
			return Response.status(404).build();
		}
		
		try {
			json = new ObjectMapper().writeValueAsString(myMessage);
			return Response.ok(json,"application/json").build();
		} catch (Exception e) {
			return Response.status(500).build();
		}			
}
}

