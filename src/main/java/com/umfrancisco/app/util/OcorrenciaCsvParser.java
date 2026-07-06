package com.umfrancisco.app.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.model.Ocorrencia;

public class OcorrenciaCsvParser extends CrimeStatsParser {
	
	private String ocorrencia = "Ocorrencia";
	private Long id = 1L;
	
	public List<Ocorrencia> readCsv(CsvFile file) throws IOException {
		if (!file.tipo().equals(ocorrencia)) {
			return null;
		}
		List<String> lines = readFromUrl(file);
		List<Ocorrencia> ocorrencias = new ArrayList<>();
		for (int i = 1; i < lines.size(); i++) {
			String[] fields = lines.get(i).split(",");
			Ocorrencia ocorrencia = new Ocorrencia(
					id++,
					file.cidade(),
					Integer.parseInt(fields[0]),
					Integer.parseInt(fields[1]),
					Integer.parseInt(fields[2]),
					Integer.parseInt(fields[3]),
					Integer.parseInt(fields[4]));
			ocorrencias.add(ocorrencia);
		}
		return ocorrencias;
	}

}
