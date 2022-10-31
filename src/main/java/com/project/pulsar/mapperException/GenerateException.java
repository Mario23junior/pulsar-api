package com.project.pulsar.mapperException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.project.pulsar.modelErro.ModelErroReturn;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class GenerateException implements ExceptionMapper<Exception> {

	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response toResponse(Exception e) {

		ModelErroReturn modelErroResponse = new ModelErroReturn();

		if (e instanceof ExceptionsRepeatedValuesReturn) {
			modelErroResponse.setMessage(e.getMessage());
 			return Response.status(Response.Status.BAD_REQUEST).entity(modelErroResponse).build();
		}

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity("Erro interno por favor entre em contado com o suporte").build();
	}

}
