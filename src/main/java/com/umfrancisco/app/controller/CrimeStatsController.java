package com.umfrancisco.app.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.app.dto.TaxaDelitoDTO;
import com.umfrancisco.app.model.TaxaDelito;
import com.umfrancisco.app.service.TaxaDelitoService;

@RestController
@RequestMapping("/api/crime")
@CrossOrigin
public class CrimeStatsController {
	
	private final TaxaDelitoService taxaDelitoService;
	
	public CrimeStatsController(TaxaDelitoService taxaDelitoService) {
		this.taxaDelitoService = taxaDelitoService;
	}
	
	@GetMapping("/data")
	public String saveAllData() throws IOException {
		String message = "";
		message += taxaDelitoService.saveAllData();
		return message;
	}
	
	@GetMapping("/cidades")
	public List<String> getCidades() {
		return List.of("sao_paulo", "campinas");
	}
	
	@GetMapping("/infracoes")
	public List<String> getInfracoes() {
		return List.of("homicidio", "roubo", "furto", "veiculo");
	}
	
	@GetMapping("/taxa_delito")
	public List<TaxaDelito> findAllTaxaDelito() throws IOException {
		return taxaDelitoService.findAll();
	}
	
	@GetMapping("/taxa_delito/{cidade}")
	public List<TaxaDelito> findTaxaDelitoByCidade(@PathVariable String cidade) {
		return taxaDelitoService.findByCidade(cidade);
	}
	
	@GetMapping("/taxa_delito/{cidade}/{infracao}")
	public List<TaxaDelitoDTO> findTaxaDelitoByCidadeAndInfracao(@PathVariable String cidade, @PathVariable String infracao) {
		return taxaDelitoService.findByCidadeAndInfracao(cidade, infracao);
	}
	
}
