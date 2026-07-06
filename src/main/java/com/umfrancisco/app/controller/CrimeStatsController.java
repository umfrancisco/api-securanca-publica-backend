package com.umfrancisco.app.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.app.model.Ocorrencia;
import com.umfrancisco.app.model.TaxaDelito;
import com.umfrancisco.app.service.OcorrenciaService;
import com.umfrancisco.app.service.TaxaDelitoService;

@RestController
@RequestMapping("/api/crime")
public class CrimeStatsController {
	
	private final OcorrenciaService ocorrenciaService;
	private final TaxaDelitoService taxaDelitoService;
	
	public CrimeStatsController(OcorrenciaService ocorrenciaService, TaxaDelitoService taxaDelitoService) {
		this.ocorrenciaService = ocorrenciaService;
		this.taxaDelitoService = taxaDelitoService;
	}
	
	@GetMapping("/data")
	public String saveAllData() throws IOException {
		String message = "";
		message += ocorrenciaService.saveAllData();
		message += " | ";
		message += taxaDelitoService.saveAllData();
		return message;
	}
	
	@GetMapping("/ocorrencia")
	public List<Ocorrencia> findAllOcorrencia() throws IOException {
		return ocorrenciaService.findAll();
	}
	
	@GetMapping("/taxa_delito")
	public List<TaxaDelito> findAllTaxaDelito() throws IOException {
		return taxaDelitoService.findAll();
	}
	
}
