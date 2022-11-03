package com.project.pulsar.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.Response;

import com.project.pulsar.dto.PulsarDto;
import com.project.pulsar.mapperException.ExceptionsRepeatedValuesReturn;
import com.project.pulsar.model.Pulsar;
import com.project.pulsar.modelErro.ResponseErro;
import com.project.pulsar.repository.PulsarRepository;

import org.modelmapper.ModelMapper;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class PulsarService {

	private PulsarRepository repository;
	private Validator validator;
	private ModelMapper mapper;

	@Inject
	public PulsarService(PulsarRepository repository, 
			Validator validator,ModelMapper mapper) {
		this.repository = repository;
		this.validator = validator;
		this.mapper = mapper;
 	}

	@Transactional
	public Response save(PulsarDto pulsarDto) {
	Optional<Pulsar> findNome = repository.findByNome(pulsarDto.getNome());
	if(findNome.isPresent()){
 		 throw new ExceptionsRepeatedValuesReturn("Pulsa "+ 
	pulsarDto.getNome() +" já esta cadastrado, por favor revise os valores");		 
	 }
		Set<ConstraintViolation<PulsarDto>> valid = validator.validate(pulsarDto);
		if(!valid.isEmpty()) {
			Response responseEntityErro = ResponseErro
			.createFromValidation(valid)
			.withStatusCode(ResponseErro.getUnprocessableEntityStatus());
			return responseEntityErro;
		}
		Pulsar pulsarBase = mapper.map(pulsarDto,Pulsar.class);
		repository.persist(pulsarBase);
		return Response
				.status(Response.Status.CREATED)
				.entity(pulsarDto)
				.build();
	}

	public Response findAllDate() {
		PanacheQuery<Pulsar> listAll = repository.findAll();
		List<PulsarDto> listId = listAll.stream()
		.map(listDataConvert -> mapper.map(listDataConvert, PulsarDto.class))
		.collect(Collectors.toList());
		return Response.ok(listId).build();
	}
	
	
	public Response findByIdPulsar(Long id) {
		PanacheQuery<Pulsar> listId = repository.find("id",id);
		if(listId.equals(null)) {
			Response.status(Response.Status.NO_CONTENT).build();
			throw new ExceptionsRepeatedValuesReturn("Pulsar de id : "+ id
					+" Não foi encontrado.");
 		}else {
 			List<PulsarDto> idDto = listId.stream()
 					.map(listDataConvert -> mapper.map(listDataConvert, PulsarDto.class))
 					.collect(Collectors.toList());
 			return Response.status(Response.Status.CREATED).entity(idDto).build();
 		}
 	}
	
	public Response findByName(String nome) {
		PanacheQuery<Pulsar> listId = repository.find("nome",nome);
		if(listId.equals(null)) {
			Response.status(Response.Status.NO_CONTENT).build();
			throw new ExceptionsRepeatedValuesReturn("O pulsar "+ nome
					+" Não foi encontrado.");
 		}else {
 			List<PulsarDto> idDto = listId.stream()
 					.map(listDataConvert -> mapper.map(listDataConvert, PulsarDto.class))
 					.collect(Collectors.toList());
 			return Response.status(Response.Status.CREATED).entity(idDto).build();
 		}
	}
		

	public Response delete(Long id) {
		Pulsar pulsar = repository.findById(id);
		if (pulsar != null) {
			repository.delete(pulsar);
			return Response.status(Response.Status.NO_CONTENT).build();
		} else {
			Response.status(Response.Status.NOT_FOUND).build();
			throw new ExceptionsRepeatedValuesReturn("Pulsar de id : "+ id
					+" Não foi encontrado, por isso não há nada a ser deletado");		 
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
