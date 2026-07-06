package com.umfrancisco.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.app.dto.TaxaDelitoDTO;
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
	
	public List<TaxaDelito> findAll() {
		return repository.findAll();
	}
	
	public List<TaxaDelito> findByCidade(String cidade) {
		return repository.findByCidade(cidade);
	}
	
	public List<TaxaDelitoDTO> findByCidadeAndInfracao(String cidade, String infracao) {
		List<TaxaDelito> dataFromDB = repository.findByCidade(cidade);
		List<TaxaDelitoDTO> dto = new ArrayList<>();
		String message = "";
		for (var d : dataFromDB) {
			switch (infracao) {
				case "Homicidio" -> dto.add(new TaxaDelitoDTO(d.getCidade(), d.getAno(), d.getHomicidio()));
				case "Furto" -> dto.add(new TaxaDelitoDTO(d.getCidade(), d.getAno(), d.getFurto()));
				case "Roubo" -> dto.add(new TaxaDelitoDTO(d.getCidade(), d.getAno(), d.getRoubo()));
				case "Veiculo" -> dto.add(new TaxaDelitoDTO(d.getCidade(), d.getAno(), d.getFrvHabitante()));
				default -> message = "[%s]: infracao '%s' not found".formatted(LocalDateTime.now(), infracao);
			}
		}
		System.out.println(message);
		return dto;
	}
	
	public String saveAllData() throws IOException {
		if (!findAll().isEmpty()) {
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
	
}
