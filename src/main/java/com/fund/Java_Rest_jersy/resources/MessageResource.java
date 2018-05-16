package com.fund.Java_Rest_jersy.resources;


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
import javax.ws.rs.core.UriInfo;

import com.fund.Java_Rest_jersy.exception.DonotFoundException;
import com.fund.Java_Rest_jersy.model.Message;
import com.fund.Java_Rest_jersy.service.MessageService;


@Path("messages")
@Produces(value= {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Consumes(value= {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {

	
//	private static final String List = null;
	 MessageService ms = new MessageService();
	
	@GET
	@Path("/{id}")
	public Message getMessage(@PathParam("id") Long id, @Context() UriInfo uriinfo) {
		
		Message m = ms.getMessage(id);
		
		if(m == null ) {
			
			throw new DonotFoundException("Check the id number");
		}
//		String s = uriinfo.getAbsolutePathBuilder().toString();
		
		String s = getUriForSelf(m, uriinfo);
		String s1 = getUriForAuthor(uriinfo, m);
		String s2 = getUriForComments(uriinfo, m);
		
		m.addLink(s, "self");
		m.addLink(s1, "author");
		m.addLink(s2, "comments");
		
		return ms.getMessage(id);
	}


	private String getUriForSelf(Message m, UriInfo uriinfo) {
		String s = uriinfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(m.getId())).build().toString();
		return s;
	}
	private String getUriForAuthor( UriInfo uriinfo, Message m) {
		String s = uriinfo.getBaseUriBuilder().path(ProfileResource.class).path(m.getAuthor()).build().toString();
		return s;
	}
	private String getUriForComments( UriInfo uriinfo, Message m) {
		String s = uriinfo.getBaseUriBuilder().path(MessageResource.class).path(CommentsResource.class).path(MessageResource.class, "comment")
				.resolveTemplate("mid", m.getId()).build().toString();
		return s;
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
