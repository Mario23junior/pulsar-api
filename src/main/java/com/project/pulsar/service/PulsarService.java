package com.project.pulsar.service;

import java.util.Optional;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

import com.project.pulsar.dto.PulsarDto;
import com.project.pulsar.mapperException.ExceptionsRepeatedValues​Return;
import com.project.pulsar.model.Pulsar;
import com.project.pulsar.modelErro.ResponseErro;
import com.project.pulsar.repository.PulsarRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class PulsarService {

	private PulsarRepository repository;
	
	
	private Validator validator;

	@Inject
	public PulsarService(PulsarRepository repository, Validator validator) {
		this.repository = repository;
		this.validator = validator;

	}

	@Transactional
	public Response save(PulsarDto pulsarDto) {

	Optional<Pulsar> findNome = repository.findByNome(pulsarDto.getNome());
	
	if(findNome.isPresent()){
	   throw new ExceptionsRepeatedValues​Return("Pulsa "+ pulsarDto.getNome() +" já esta cadastrado, por favor revise os valores");
	 }
		Set<ConstraintViolation<PulsarDto>> valid = validator.validate(pulsarDto);
		if(!valid.isEmpty()) {
			Response responseEntityErro = ResponseErro
			.createFromValidation(valid)
			.withStatusCode(ResponseErro.getUnprocessableEntityStatus());
			return responseEntityErro;
			 
		}
		Pulsar p = new Pulsar();
		p.setNome(pulsarDto.getNome());
		p.setImgSimulacao(pulsarDto.getImgSimulacao());
		p.setNomeConstelacao(pulsarDto.getNomeConstelacao());
		p.setDistancia(pulsarDto.getDistancia());
		p.setAscReta(pulsarDto.getAscReta());
		repository.persist(p);
		return Response
				.status(Response.Status.CREATED)
				.entity(pulsarDto)
				.build();
	}

	public Response findAllDate() {
		PanacheQuery<Pulsar> listAll = repository.findAll();
		return Response.ok(listAll.list()).build();
	}

	public Response delete(Long id) {
		Pulsar pulsar = repository.findById(id);

		if (pulsar != null) {
			repository.delete(pulsar);
			return Response.status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	public Response updateBase(Long id, PulsarDto pulsarDto) {
		Pulsar pulsar = repository.findById(id);

		if (pulsar != null) {
			pulsar.setNome(pulsarDto.getNome());
			pulsar.setImgSimulacao(pulsarDto.getImgSimulacao());
			pulsar.setNomeConstelacao(pulsarDto.getNomeConstelacao());
			pulsar.setDistancia(pulsarDto.getDistancia());
			pulsar.setAscReta(pulsarDto.getAscReta());
			return Response.status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
