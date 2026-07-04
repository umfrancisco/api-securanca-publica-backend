package com.umfrancisco.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.app.model.Crime;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.repository.CsvFileRepository;
import com.umfrancisco.app.util.OcorrenciaCsvParser;

@RestController
@RequestMapping("/api/crime")
public class CrimeStatsController {
	
	private final OcorrenciaCsvParser ocorrenciaCsvParser;
	private final CsvFileRepository repository;
	
	public CrimeStatsController(OcorrenciaCsvParser ocorrenciaCsvParser, CsvFileRepository repository) {
		this.ocorrenciaCsvParser = ocorrenciaCsvParser;
		this.repository = repository;
	}
	
	@GetMapping("/ocorrencia")
	public List<Crime> findAllOcorrencias() throws IOException {
		List<CsvFile> csvFiles = repository.findAll();
		List<Crime> allData = new ArrayList<Crime>();
		for (var csvFile : csvFiles) {
			List<Crime> data = ocorrenciaCsvParser.readCsv(csvFile);
			if (data != null) {
				allData.addAll(data);				
			}
		}
		return allData;
	}
	
}
