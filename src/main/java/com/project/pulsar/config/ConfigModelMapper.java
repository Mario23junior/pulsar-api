package com.project.pulsar.config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;

import org.modelmapper.ModelMapper;

@Singleton
public class ConfigModelMapper {
  	
	@ApplicationScoped
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
