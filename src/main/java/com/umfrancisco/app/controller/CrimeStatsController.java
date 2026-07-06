package com.umfrancisco.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.app.dto.OcorrenciaDTO;
import com.umfrancisco.app.dto.TaxaDelitoDTO;
import com.umfrancisco.app.model.Ocorrencia;
import com.umfrancisco.app.model.TaxaDelito;
import com.umfrancisco.app.service.OcorrenciaService;
import com.umfrancisco.app.service.TaxaDelitoService;

@RestController
@RequestMapping("/api/crime")
@CrossOrigin
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
	
	@GetMapping("/Ocorrencia")
	public List<Ocorrencia> findAllOcorrencia() throws IOException {
		return ocorrenciaService.findAll();
	}
	
	@GetMapping("/Ocorrencia/{cidade}")
	public List<Ocorrencia> findOcorrenciaByCidade(@PathVariable String cidade) {
		return ocorrenciaService.findByCidade(cidade);
	}
	
	@GetMapping("/Ocorrencia/{cidade}/{infracao}")
	public List<OcorrenciaDTO> findOcorrenciaByCidadeAndInfracao(@PathVariable String cidade, @PathVariable String infracao) {
		return ocorrenciaService.findByCidadeAndInfracao(cidade, infracao);
	}
	
	@GetMapping("/Taxa Delito")
	public List<TaxaDelito> findAllTaxaDelito() throws IOException {
		return taxaDelitoService.findAll();
	}
	
	@GetMapping("/Taxa Delito/{cidade}")
	public List<TaxaDelito> findTaxaDelitoByCidade(@PathVariable String cidade) {
		return taxaDelitoService.findByCidade(cidade);
	}
	
	@GetMapping("/Taxa Delito/{cidade}/{infracao}")
	public List<TaxaDelitoDTO> findTaxaDelitoByCidadeAndInfracao(@PathVariable String cidade, @PathVariable String infracao) {
		return taxaDelitoService.findByCidadeAndInfracao(cidade, infracao);
	}
	
}
