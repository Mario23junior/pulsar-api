package com.project.pulsar.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.pulsar.dto.PulsarDto;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/project/pulsar/")
public class PulsarController {

	@POST
	public Response save(PulsarDto pulsarDto) {
		return Response.ok().build();
	}
}
