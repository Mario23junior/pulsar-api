package com.project.pulsar.controller;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.pulsar.dto.PulsarDto;
import com.project.pulsar.model.Pulsar;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/project/pulsar/")
public class PulsarController {

	@POST
	@Transactional
	public Response save(PulsarDto pulsarDto) {
		Pulsar p = new Pulsar();
		p.setNome(pulsarDto.getNome());
		p.setImgSimulacao(pulsarDto.getImgSimulacao());
		p.setNomeConstelacao(pulsarDto.getNomeConstelacao());
		p.setDistancia(pulsarDto.getDistancia());
		p.setAscReta(pulsarDto.getAscReta());
		p.persist();
		return Response.ok(p).build();
	
 	}
	
	@GET
	public Response listAll() {
		return Response.ok().build();
	}
}
