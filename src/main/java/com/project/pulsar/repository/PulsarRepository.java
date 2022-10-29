package com.project.pulsar.repository;

import javax.enterprise.context.ApplicationScoped;

import com.project.pulsar.model.Pulsar;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class PulsarRepository implements PanacheRepositoryBase<Pulsar, Long> {
  
	
}
