package com.umfrancisco.app.util;

import java.util.List;

public interface CrimeStatsParser {
	List<String> readFromUrl(String urlString);
}
