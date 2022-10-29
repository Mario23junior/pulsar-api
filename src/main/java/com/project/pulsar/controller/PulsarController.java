package com.project.pulsar.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.pulsar.dto.PulsarDto;
import com.project.pulsar.service.PulsarService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/project/pulsar/")
public class PulsarController {
    
	@Inject
	private PulsarService service;
	
	public PulsarController( PulsarService service) {
		this.service = service;
	}
 
	@POST
	@Transactional
	public Response save(PulsarDto pulsarDto) {
		return service.save(pulsarDto);

	}

	@GET
	public Response listAll() {
		return service.findAllDate();
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public Response delete(@PathParam("id") Long id) {
		return service.delete(id);
	}
	
	@PUT
	@Transactional
	@Path("{id}")
	public Response update(@PathParam("id")Long id,PulsarDto pulsarDto) {
		return service.updateBase(id, pulsarDto);
	}
}
