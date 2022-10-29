package com.project.pulsar.repository;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import com.project.pulsar.model.Pulsar;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class PulsarRepository implements PanacheRepositoryBase<Pulsar, Long> {

	public Optional<Pulsar> findByNome(String nome) {
		return find("nome",nome).firstResultOptional();
	}
  
	
}
