package com.fund.Java_Rest_jersy.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.fund.Java_Rest_jersy.model.Message;
import com.fund.Java_Rest_jersy.service.MessageService;


@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	
//	private static final String List = null;
	 MessageService ms = new MessageService();
	
	@GET
	@Path("/{id}")
	public Message getMessage(@PathParam("id") Long id) {
		
//		List<Message> li = ms.getAllMessages();
//		
//		String r ="";
//		for(Message m: li) {
//		
//			if(m.getId()==id) {
//				
//				r += m.toString(); 
//			}
//		}	
		
		return ms.getMessage(id);
	}
	
	
	@GET
	public List<Message> getMessage1() {
		
		return ms.getAllMessages();
	}
	
	
	@POST
	public Response createMessage(Message m, @Context() UriInfo uriInfo ) throws URISyntaxException {
		
		Message mi = ms.putMessage(m);
	//return	Response.status(Status.CREATED).entity().build();
		//return Response.created(new URI("messages/"+mi.getId())).entity(mi).build();
		return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(mi.getId())).build()).entity(mi).build();
//		return ms.putMessage(m);
		//return "hello form post";
	}

	@DELETE
	@Path("/{id}")
	public void deleteMessage(@PathParam("id") Long id) {
		
		 ms.deleteMessage(id);
	}
	
	@PUT
	@Path("/{id}")
	public Message updateMessage(Message m, @PathParam("id") long id) {
		m.setId(id);
		return ms.updateMessage(m);
	}
	
	
	
	@Path("/{mid}/comments")
	public CommentsResource comment() {
		return new CommentsResource();
	}
}
