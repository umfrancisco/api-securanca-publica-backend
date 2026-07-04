package com.umfrancisco.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.app.model.Crime;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.repository.CsvFileRepository;
import com.umfrancisco.app.util.OcorrenciaCsvParser;

@Service
public class CrimeStatsService {
	
	private final OcorrenciaCsvParser ocorrenciaCsvParser;
	private final CsvFileRepository repository;
	
	public CrimeStatsService(OcorrenciaCsvParser ocorrenciaCsvParser, CsvFileRepository repository) {
		this.repository = repository;
		this.ocorrenciaCsvParser = ocorrenciaCsvParser;
	}
	
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
