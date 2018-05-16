package com.fund.Java_Rest_jersy.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fund.Java_Rest_jersy.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DonotFoundException>{

	@Override
	public Response toResponse(DonotFoundException exception) {
		ErrorMessage er = new ErrorMessage(exception.getMessage(), 404, "this is error :)");
		return Response.status(Status.NOT_FOUND).entity(er).build();
	}

}
