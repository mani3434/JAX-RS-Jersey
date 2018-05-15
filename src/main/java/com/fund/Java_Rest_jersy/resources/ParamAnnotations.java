package com.fund.Java_Rest_jersy.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("annotations")
@Produces(MediaType.APPLICATION_JSON)
public class ParamAnnotations {

	
	
	@GET
	public String getAnnotation(@MatrixParam("name") String name, @MatrixParam("age") String age, @HeaderParam("token") String s, @CookieParam("test") String cookie) {
		
		return "hi "+ name+ "! you are "+age+" old: security token is "+ s+" cookie value is: "+ cookie;
	}
	
	@GET
	@Path("/context")
	public String contextAnnotaion(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		return "uri information:" +uriInfo.getAbsolutePath().toString() +"\n"+ uriInfo.getPathSegments()+"\n"+headers.getCookies().toString();
	}
	
}
