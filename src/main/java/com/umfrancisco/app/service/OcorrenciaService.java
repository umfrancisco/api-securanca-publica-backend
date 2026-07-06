package com.umfrancisco.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.model.Ocorrencia;
import com.umfrancisco.app.repository.CrimeDatasetUrlFiles;
import com.umfrancisco.app.repository.OcorrenciaRepository;
import com.umfrancisco.app.util.OcorrenciaCsvParser;

@Service
public class OcorrenciaService {
	
	private OcorrenciaRepository repository;
	private OcorrenciaCsvParser csvParser;
	
	public OcorrenciaService(OcorrenciaRepository repository, OcorrenciaCsvParser csvParser) {
		this.repository = repository;
		this.csvParser = csvParser;
	}
	
	public String saveAllData() throws IOException {
		if (!repository.findAll().isEmpty()) {
			return getClass().getSimpleName()+": database not empty";
		}
		List<CsvFile> csvFiles = CrimeDatasetUrlFiles.findAllOcorrenciaFiles();
		List<Ocorrencia> data = new ArrayList<>();
		for (var file : csvFiles) {
			data.addAll(csvParser.readCsv(file));
		}
		repository.saveAll(data);
		return getClass().getSimpleName()+": saved data";
	}
	
	public List<Ocorrencia> findAll() {
		return repository.findAll();
	}
	
}
