package com.project.pulsar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PULSAR")
public class Pulsar  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(length = 200)
	private String imgSimulacao;
	private String nomeConstelacao;
	private String ascReta;
	private Double distancia;

	public Pulsar() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImgSimulacao() {
		return imgSimulacao;
	}

	public void setImgSimulacao(String imgSimulacao) {
		this.imgSimulacao = imgSimulacao;
	}

	public String getNomeConstelacao() {
		return nomeConstelacao;
	}

	public void setNomeConstelacao(String nomeConstelacao) {
		this.nomeConstelacao = nomeConstelacao;
	}

	public String getAscReta() {
		return ascReta;
	}

	public void setAscReta(String ascReta) {
		this.ascReta = ascReta;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

}
