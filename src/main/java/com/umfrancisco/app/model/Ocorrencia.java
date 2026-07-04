package com.umfrancisco.app.model;

public record Ocorrencia(
		String cidade, 
		int ano, 
		int homicidio, 
		int furto, 
		int roubo, 
		int furtoRouboVeiculo) implements Crime {
	
}
