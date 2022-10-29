package com.project.pulsar.modelErro;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.ws.rs.core.Response;

public class ResponseErro {

	private static final Integer UNPROCESSABLE_ENTITY_STATUS = 224;
	private String message;
	private Collection<modelErroReturn> errors;

	public ResponseErro(String message, Collection<modelErroReturn> errors) {
		super();
		this.message = message;
		this.errors = errors;
	}

	public static <T>ResponseErro createFromValidation(Set<ConstraintViolation<T>> violations) {
		List<modelErroReturn> erroReturn = violations.stream()
				.map(cons -> new modelErroReturn(cons.getPropertyPath()
						.toString(),cons
						.getMessage()) )
				        .collect(Collectors.toList());
		
		String message = "Erro de validação por favor, preencha todos os campos marcados como obrigatórios";
		
		ResponseErro bundleErroResponse = new ResponseErro(message,erroReturn);
		return bundleErroResponse;
        
	}

	public ResponseErro() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Collection<modelErroReturn> getErrors() {
		return errors;
	}

	public void setErrors(Collection<modelErroReturn> errors) {
		this.errors = errors;
	}
	
	public Response withStatusCode(int code) {
		return Response.status(code).entity(this).build();
	}

	public static Integer getUnprocessableEntityStatus() {
		return UNPROCESSABLE_ENTITY_STATUS;
		
	}
	

}
