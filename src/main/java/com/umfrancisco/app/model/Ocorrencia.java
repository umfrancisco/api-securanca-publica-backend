package com.umfrancisco.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ocorrencia {
	
	@Id
	private Long id;
	private String cidade; 
	private int ano;
	private int homicidio;
	private int furto;
	private int roubo; 
	private int furtoRouboVeiculo;
	
	public Ocorrencia() {
		
	}
	
	public Ocorrencia(Long id, String cidade, int ano, int homicidio, int furto, int roubo, int furtoRouboVeiculo) {
		this.id = id;
		this.cidade = cidade;
		this.ano = ano;
		this.homicidio = homicidio;
		this.furto = furto;
		this.roubo = roubo;
		this.furtoRouboVeiculo = furtoRouboVeiculo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getHomicidio() {
		return homicidio;
	}
	public void setHomicidio(int homicidio) {
		this.homicidio = homicidio;
	}
	public int getFurto() {
		return furto;
	}
	public void setFurto(int furto) {
		this.furto = furto;
	}
	public int getRoubo() {
		return roubo;
	}
	public void setRoubo(int roubo) {
		this.roubo = roubo;
	}
	public int getFurtoRouboVeiculo() {
		return furtoRouboVeiculo;
	}
	public void setFurtoRouboVeiculo(int furtoRouboVeiculo) {
		this.furtoRouboVeiculo = furtoRouboVeiculo;
	}
	
	@Override
	public String toString() {
		return "Ocorrencia [id=" + id + ", cidade=" + cidade + ", ano=" + ano + ", homicidio=" + homicidio + ", furto="
				+ furto + ", roubo=" + roubo + ", furtoRouboVeiculo=" + furtoRouboVeiculo + "]";
	}
	
}
