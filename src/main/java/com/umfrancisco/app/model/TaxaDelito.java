package com.umfrancisco.app.model;

public record TaxaDelito(
		String cidade, 
		int ano, 
		double homicidio,
		double furto,
		double roubo,
		double frvHabitante,
		double furtoVeiculo,
		double rouboVeiculo,
		double frvVeiculo) implements Crime {
	
}
