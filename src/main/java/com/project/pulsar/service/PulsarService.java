package com.project.pulsar.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.project.pulsar.dto.PulsarDto;
import com.project.pulsar.model.Pulsar;
import com.project.pulsar.repository.PulsarRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;


@ApplicationScoped
public class PulsarService {
    
	private PulsarRepository repository;

	@Inject
	public PulsarService(PulsarRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Response save(PulsarDto pulsarDto) {
		Pulsar p = new Pulsar();
		p.setNome(pulsarDto.getNome());
		p.setImgSimulacao(pulsarDto.getImgSimulacao());
		p.setNomeConstelacao(pulsarDto.getNomeConstelacao());
		p.setDistancia(pulsarDto.getDistancia());
		p.setAscReta(pulsarDto.getAscReta());
		repository.persist(p);
 		return Response.ok(p).build();
	}
	
	public Response findAllDate() {
		PanacheQuery<Pulsar> listAll = repository.findAll();
		return Response.ok(listAll.list()).build();
	}
	
	public Response delete(Long id) {
		Pulsar pulsar = repository.findById(id);
		
		if(pulsar != null) {
		   repository.delete(pulsar);
		   return Response.ok().build();
		}else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	
	public Response updateBase(Long id, PulsarDto pulsarDto) {
		
		Pulsar pulsar = repository.findById(id);
		
		if(pulsar != null) {
			pulsar.setNome(pulsarDto.getNome());
			pulsar.setImgSimulacao(pulsarDto.getImgSimulacao());
			pulsar.setNomeConstelacao(pulsarDto.getNomeConstelacao());
			pulsar.setDistancia(pulsarDto.getDistancia());
			pulsar.setAscReta(pulsarDto.getAscReta());
 			return Response.ok().build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}	
	}
}



















