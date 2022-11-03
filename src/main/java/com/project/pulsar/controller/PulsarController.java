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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.pulsar.dto.PulsarDto;
import com.project.pulsar.service.PulsarService;

import org.eclipse.microprofile.openapi.annotations.Operation;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/project/pulsar/")
public class PulsarController {
    
	@Inject
	private PulsarService service;
	
	public PulsarController( PulsarService service) {
		this.service = service;
	}
 
	@Operation(
	summary = "Salvando pulsa",
	description = "Salvando um novo pulsar no banco de dados.")
	@POST
	@Transactional
	public Response save(PulsarDto pulsarDto) {
		return service.save(pulsarDto);
	}
	
	@Operation(
	summary = "Listando pulsar por id",
    description = "Obtendo pulsar por id de identificação")
	@GET
	@Path("{id}")
 	public Response findId(@PathParam("id") Long id) {
		return service.findByIdPulsar(id);
	}
	
	@Operation(
	summary = "Listando pulsar por nome",
	description = "Obtendo pulsar por nome de identificação")
	@GET
	@Path("nome")
	public Response findName(@QueryParam("nome")String nome) {
		return service.findByName(nome);
	}

	@Operation(
	summary = "Listando todos os pulsare.",
	description = "Listando todos os pulsares registrados no banco de dados.")
	@GET
	public Response listAll() {
		return service.findAllDate();
	}
	
	@Operation(
	summary = "Deletando pulsares por id",
	description = "Deletando um pulsar registrados no banco de dados.")
	@DELETE
	@Path("{id}")
	@Transactional
	public Response delete(@PathParam("id") Long id) {
		return service.delete(id);
	}
	
	@Operation(
	summary = "Atualizando um pulsar",
	description = "Atualizando pulsar registrados no banco de dados.")
	@PUT
	@Transactional
	@Path("{id}")
	public Response update(@PathParam("id")Long id,PulsarDto pulsarDto) {
		return service.updateBase(id, pulsarDto);
	}
}
