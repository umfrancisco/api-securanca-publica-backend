package com.umfrancisco.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.model.TaxaDelito;
import com.umfrancisco.app.repository.CrimeDatasetUrlFiles;
import com.umfrancisco.app.repository.TaxaDelitoRepository;
import com.umfrancisco.app.util.TaxaDelitoCsvParser;

@Service
public class TaxaDelitoService {
	
	private TaxaDelitoRepository repository;
	private TaxaDelitoCsvParser csvParser;
	
	public TaxaDelitoService(TaxaDelitoRepository repository, TaxaDelitoCsvParser csvParser) {
		this.repository = repository;
		this.csvParser = csvParser;
	}
	
	public String saveAllData() throws IOException {
		if (!repository.findAll().isEmpty()) {
			return getClass().getSimpleName()+": database not empty";
		}
		List<CsvFile> csvFiles = CrimeDatasetUrlFiles.findAllTaxaDelitoFiles();
		List<TaxaDelito> data = new ArrayList<>();
		for (var file : csvFiles) {
			data.addAll(csvParser.readCsv(file));
		}
		repository.saveAll(data);
		return getClass().getSimpleName()+": saved data";
	}
	
	public List<TaxaDelito> findAll() {
		return repository.findAll();
	}
	
}
