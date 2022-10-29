package com.project.pulsar.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PulsarDto {

	private Long id;
	
	@NotBlank(message = "Nome do pulsar e o obrigatorio")
	private String nome;
	
 	private String imgSimulacao;
	
	@NotBlank(message = "por favor insira o nome da costelação proxima")
	private String nomeConstelacao;
	
	@NotBlank(message = "insira o valor da senção reta em reção a distancia da terra.")
	private String ascReta;
	
	@NotNull(message = "Insira a disntancia estimada.")
	private Double distancia;

	public PulsarDto() {
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
