package com.umfrancisco.app.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.app.model.Crime;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.util.OcorrenciaCsvParser;

@RestController
@RequestMapping("/api/crime")
public class CrimeStatsController {
	
	private final OcorrenciaCsvParser ocorrenciaCsvParser;
	
	public CrimeStatsController(OcorrenciaCsvParser ocorrenciaCsvParser) {
		this.ocorrenciaCsvParser = ocorrenciaCsvParser;
	}
	
	@GetMapping("/ocorrencia")
	public List<Crime> findAllOcorrencias() throws IOException {
		return ocorrenciaCsvParser.readCsv(
				new CsvFile("São Paulo", "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/OcorrenciaAnual-S%C3%A3o%20Paulo_20260704_164347.csv"));
	}
	
}
