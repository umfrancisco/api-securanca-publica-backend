package com.umfrancisco.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.umfrancisco.app.model.Crime;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.model.Ocorrencia;

public class OcorrenciaCsvParser implements CrimeStatsParser {

	@Override
	public List<String> readFromUrl(CsvFile file) throws IOException {
		URL url = new URL(file.url());
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(url.openStream()))
		) {
			return reader.lines().collect(Collectors.toList());
		}
	}

	@Override
	public List<Crime> readCsv(CsvFile file) throws IOException {
		if (!file.tipo().equals("Ocorrencia")) {
			return null;
		}
		List<String> lines = readFromUrl(file);
		List<Crime> ocorrencias = new ArrayList<>();
		for (int i = 1; i < lines.size(); i++) {
			String[] fields = lines.get(i).split(",");
			Ocorrencia ocorrencia = new Ocorrencia(
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
