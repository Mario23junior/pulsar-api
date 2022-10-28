package com.project.pulsar.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.pulsar.dto.PulsarDto;

@Path("/v1/project/pulsar/")
public class PulsarController {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(PulsarDto pulsarDto) {
		return Response.ok().build();
	}
}
