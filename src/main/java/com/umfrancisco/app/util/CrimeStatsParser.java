package com.umfrancisco.app.util;

import java.util.List;

import com.umfrancisco.app.model.Crime;

public interface CrimeStatsParser {
	List<String> readFromUrl(String urlString);
	List<Crime> readCsv();
}
