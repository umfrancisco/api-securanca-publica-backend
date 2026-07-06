package com.umfrancisco.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.app.model.Crime;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.repository.CrimeDataset;
import com.umfrancisco.app.util.OcorrenciaCsvParser;
import com.umfrancisco.app.util.TaxaDelitoCsvParser;

@Service
public class CrimeStatsService {
	
	private final OcorrenciaCsvParser ocorrenciaCsvParser;
	private final TaxaDelitoCsvParser taxaDelitoCsvParser;
	
	public CrimeStatsService(OcorrenciaCsvParser ocorrenciaCsvParser, TaxaDelitoCsvParser taxaDelitoCsvParser) {
		this.ocorrenciaCsvParser = ocorrenciaCsvParser;
		this.taxaDelitoCsvParser = taxaDelitoCsvParser;
	}
	
	public List<Crime> findByCidade(String cidade, String tipo) throws IOException {
		List<CsvFile> files = CrimeDataset.findByCidadeAndTipo(cidade.toLowerCase(), tipo);
		List<Crime> allData = new ArrayList<Crime>();
		for (var file : files) {
			if (file.tipo().equalsIgnoreCase(Crime.ocorrencia)) {
				List<Crime> data = ocorrenciaCsvParser.readCsv(file);
				allData.addAll(data);
			}
			if (file.tipo().equalsIgnoreCase(Crime.taxaDelito)) {
				List<Crime> data = taxaDelitoCsvParser.readCsv(file);
				allData.addAll(data);
			}
		}
		return allData;
	}
	
	public List<Crime> findAllDataByType(String tipo) throws IOException {
		List<CsvFile> requestedCsvFiles = CrimeDataset.findAll();
		List<Crime> requestedData = new ArrayList<Crime>();
		for (var csvFile : requestedCsvFiles) {
			List<Crime> data = null;
			if (tipo.equals(Crime.ocorrencia)) {
				data = ocorrenciaCsvParser.readCsv(csvFile);				
			}
			if (tipo.equals(Crime.taxaDelito)) {
				data = taxaDelitoCsvParser.readCsv(csvFile);
			}
			if (data != null) {
				requestedData.addAll(data);				
			}
		}
		return requestedData;
	}
	
}
