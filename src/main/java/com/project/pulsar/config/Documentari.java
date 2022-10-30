package com.project.pulsar.config;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(//
	    tags = { //
	        @Tag(name = "API de listagem de pulsares registrados"), //
	        @Tag(name = "Pulsar-API", description = "O bjetivo e ter informaçãoes sobre o fato, do desligamento parece ocorrer aproximadamente após 10 a 100 milhões de anos.")//
	    }, //
	    info = @Info(//
	        title = "API Pulsar", //
	        version = "1.0.0", //
	        contact = @Contact(//
	            name = "Pulsar é uma estrela de nêutrons que, em virtude de seu intenso campo magnético, transforma a energia rotacional em energia eletromagnética."
	            		+ " A medida que o pulsar gira, seu intenso campo magnético induz um enorme campo elétrico na sua superfície.", //
	            url = "https://github.com/Mario23junior")), //
	    servers = { //
	        @Server(url = "http://localhost:8080")//
	    }) //
public class Documentari extends Application {

}
