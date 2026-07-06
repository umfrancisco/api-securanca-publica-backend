package com.umfrancisco.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.app.dto.OcorrenciaDTO;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.model.Ocorrencia;
import com.umfrancisco.app.repository.CrimeDatasetUrlFiles;
import com.umfrancisco.app.repository.OcorrenciaRepository;
import com.umfrancisco.app.util.Constants;
import com.umfrancisco.app.util.OcorrenciaCsvParser;

@Service
public class OcorrenciaService {
	
	private OcorrenciaRepository repository;
	private OcorrenciaCsvParser csvParser;
	
	public OcorrenciaService(OcorrenciaRepository repository, OcorrenciaCsvParser csvParser) {
		this.repository = repository;
		this.csvParser = csvParser;
	}
	
	public List<Ocorrencia> findAll() {
		return repository.findAll();
	}
	
	public List<Ocorrencia> findByCidade(String cidade) {
		return repository.findByCidade(cidade);
	}
	
	public List<OcorrenciaDTO> findByCidadeAndInfracao(String cidade, String infracao) {
		List<Ocorrencia> dataFromDB = repository.findByCidade(cidade);
		List<OcorrenciaDTO> dto = new ArrayList<>();
		String message = "";
		for (var d : dataFromDB) {
			switch (infracao) {
				case Constants.homicidio -> dto.add(new OcorrenciaDTO(d.getCidade(), d.getAno(), d.getHomicidio()));
				case Constants.furto -> dto.add(new OcorrenciaDTO(d.getCidade(), d.getAno(), d.getFurto()));
				case Constants.roubo -> dto.add(new OcorrenciaDTO(d.getCidade(), d.getAno(), d.getRoubo()));
				case Constants.veiculo -> dto.add(new OcorrenciaDTO(d.getCidade(), d.getAno(), d.getFurtoRouboVeiculo()));
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
		List<CsvFile> csvFiles = CrimeDatasetUrlFiles.findAllOcorrenciaFiles();
		List<Ocorrencia> data = new ArrayList<>();
		for (var file : csvFiles) {
			data.addAll(csvParser.readCsv(file));
		}
		repository.saveAll(data);
		return getClass().getSimpleName()+": saved data";
	}
	
}
