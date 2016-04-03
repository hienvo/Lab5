package servlets;

import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Todo
 */
@Path("/")
public class TodoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConcurrentHashMap<String, String> myMessage = new ConcurrentHashMap<String, String>();

	public TodoServlet() {
		super();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/idjson")
	public Response getIdmessageJSON(@PathParam("id") String id) {
		return Response.ok(myMessage.get(id), "application/json").build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/idxml")
	public Response getIdmessageXML(@PathParam("id") String id) {
		return Response.ok(myMessage.get(id), "application/xml").build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/alljson")
	public Response getAllmessageJSON() {
		return Response.ok(myMessage, "application/json").build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML })
	@Path("/allxml")
	public Response getAllmessageXML() {
		return Response.ok(myMessage, "application/xml").build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/create")
	public Response createMessage(@PathParam("id") String id, @PathParam("message") String message) {
		myMessage.put(id, message);
		return Response.ok("Success!", "application/json").build();
	}

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/delete")
	public Response deleteId(@PathParam("id") String id) {
		myMessage.remove(id);
		String out ="Success!";
		if (myMessage.get(id) == null) {
			 out = "Error";
		}
		return Response.ok(out, "application/json").build();
	}

}