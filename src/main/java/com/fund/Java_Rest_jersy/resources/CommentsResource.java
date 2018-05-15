package com.fund.Java_Rest_jersy.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fund.Java_Rest_jersy.model.Comments;
import com.fund.Java_Rest_jersy.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentsResource {

	
	private CommentService cs = new CommentService();
	
	
	@GET
	@Path("/{id}")
	public Comments subResource(@PathParam("mid") int mid, @PathParam("id") int id) {
		
		//return "these are the messages for "+mid+" and comment id is "+id;
		return cs.getComment(mid, id);
		
	}
	
	@GET
	public List<Comments> getAllComments(@PathParam("mid") int mid){
		
		return cs.allCommnets(mid);
		
	}
	
	@POST
	public Comments postComment(@PathParam("mid") long mid, Comments comment) {
		
		return cs.addComment(mid, comment);
	} 

	@PUT
	@Path("/{id}")
	public Comments putComment(@PathParam("mid") long mid, @PathParam("id") long id,  Comments comment) {
		
		comment.setId(id);
		return cs.updateComment(mid, comment);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteComments(@PathParam("mid") long mid, @PathParam("id") long id ){
		
			cs.deleteComment(mid, id);
		
	}

	
	
}
