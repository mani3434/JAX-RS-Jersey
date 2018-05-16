package com.fund.Java_Rest_jersy.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fund.Java_Rest_jersy.model.ErrorMessage;

//@Provider
public class GenericException implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage er = new ErrorMessage(exception.getMessage(), 404, "this is error :)");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(er).build();
	}
}
