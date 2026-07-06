package com.umfrancisco.app.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.model.TaxaDelito;

public class TaxaDelitoCsvParser extends CrimeStatsParser {
	
	private String taxaDelito = "TaxaDelito";
	private Long id = 1L;

	public List<TaxaDelito> readCsv(CsvFile file) throws IOException {
		if (!file.tipo().equals(taxaDelito)) {
			return null;
		}
		List<String> lines = readFromUrl(file);
		List<TaxaDelito> taxaDelitos = new ArrayList<>();
		for (int i = 1; i < lines.size(); i++) {
			String[] fields = lines.get(i).split(",");
			TaxaDelito delito = new TaxaDelito(
					id++,
					file.cidade(),
					Integer.parseInt(fields[0]),
					Double.parseDouble(fields[1]),
					Double.parseDouble(fields[2]),
					Double.parseDouble(fields[3]),
					Double.parseDouble(fields[4]));
			taxaDelitos.add(delito);
		}
		return taxaDelitos;
	}

}
