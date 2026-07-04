package com.umfrancisco.app.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.app.model.Crime;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.service.CrimeStatsService;

@RestController
@RequestMapping("/api/crime")
public class CrimeStatsController {
	
	private final CrimeStatsService service;
	
	public CrimeStatsController(CrimeStatsService service) {
		this.service = service;
	}
	
	@GetMapping("/ocorrencia")
	public List<Crime> findAllOcorrencias() throws IOException {
		return service.findAllOcorrencias();
	}
	
	@GetMapping("/ocorrencia/{cidade}")
	public List<Crime> findByCidadeAndOcorrencia(@PathVariable String cidade) throws IOException {
		return service.findByCidadeAndOcorrencia(cidade);
	}
	
	@PostMapping("/data")
	public String addAllData(@RequestBody List<CsvFile> files) {
		return service.saveAll(files);
	}
	
}
