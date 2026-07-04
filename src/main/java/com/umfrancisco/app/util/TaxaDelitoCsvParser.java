package com.umfrancisco.app.util;

import java.util.List;
import com.umfrancisco.app.model.Crime;
import com.umfrancisco.app.model.CsvFile;

public class TaxaDelitoCsvParser implements CrimeStatsParser {

	@Override
	public List<String> readFromUrl(CsvFile file) {
		return null;
	}

	@Override
	public List<Crime> readCsv(CsvFile file) {
		return null;
	}

}
