package com.project.pulsar.dto;

public class PulsarDto {

	private Long id;
	private String nome;
	private String imgSimulacao;
	private String nomeConstelacao;
	private String ascReta;
	private String distancia;

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

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

}
