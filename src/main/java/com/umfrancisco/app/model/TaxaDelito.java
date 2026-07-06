package com.umfrancisco.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TaxaDelito {
	
	@Id
	private Long id;
	private String cidade;
	private int ano;
	private double homicidio;
	private double furto;
	private double roubo;
	private double frvHabitante;
	
	public TaxaDelito() {
		
	}
	
	public TaxaDelito(Long id, String cidade, int ano, double homicidio, double furto, double roubo,
			double frvHabitante) {
		this.id = id;
		this.cidade = cidade;
		this.ano = ano;
		this.homicidio = homicidio;
		this.furto = furto;
		this.roubo = roubo;
		this.frvHabitante = frvHabitante;
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
	public double getHomicidio() {
		return homicidio;
	}
	public void setHomicidio(double homicidio) {
		this.homicidio = homicidio;
	}
	public double getFurto() {
		return furto;
	}
	public void setFurto(double furto) {
		this.furto = furto;
	}
	public double getRoubo() {
		return roubo;
	}
	public void setRoubo(double roubo) {
		this.roubo = roubo;
	}
	public double getFrvHabitante() {
		return frvHabitante;
	}
	public void setFrvHabitante(double frvHabitante) {
		this.frvHabitante = frvHabitante;
	}
	
	@Override
	public String toString() {
		return "TaxaDelito [id=" + id + ", cidade=" + cidade + ", ano=" + ano + ", homicidio=" + homicidio + ", furto="
				+ furto + ", roubo=" + roubo + ", frvHabitante=" + frvHabitante + "]";
	}
	
}
