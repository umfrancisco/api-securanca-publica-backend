package com.umfrancisco.app.util;

import java.io.IOException;
import java.util.List;

import com.umfrancisco.app.model.Crime;
import com.umfrancisco.app.model.CsvFile;

public interface CrimeStatsParser {
	List<String> readFromUrl(CsvFile file) throws IOException;
	List<Crime> readCsv(CsvFile file) throws IOException;
}
