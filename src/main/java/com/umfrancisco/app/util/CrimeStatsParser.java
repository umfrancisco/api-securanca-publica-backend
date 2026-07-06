package com.umfrancisco.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import com.umfrancisco.app.model.Crime;
import com.umfrancisco.app.model.CsvFile;

public abstract class CrimeStatsParser {
	
	public List<String> readFromUrl(CsvFile file) throws IOException {
		URL url = new URL(file.url());
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(url.openStream()))
		) {
			return reader.lines().collect(Collectors.toList());
		}
	}
	
	public abstract List<Crime> readCsv(CsvFile file) throws IOException;
}
