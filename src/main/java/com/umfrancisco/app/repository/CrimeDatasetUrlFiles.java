package com.umfrancisco.app.repository;

import java.util.List;
import com.umfrancisco.app.model.CsvFile;

public class CrimeDatasetUrlFiles {
	
	private static List<CsvFile> taxaDelitoFiles = List.of(
			new CsvFile("São Paulo-TaxaDelito", "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-S%C3%A3o%20Paulo_20260704_164249.csv"),
			new CsvFile("Campinas-TaxaDelito", "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-Campinas_20260704_194100.csv")
	);
	
	private static List<CsvFile> ocorrenciaFiles = List.of(
			new CsvFile("São Paulo-Ocorrencia", "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/OcorrenciaAnual-S%C3%A3o%20Paulo_20260704_164347.csv"),
			new CsvFile("Campinas-Ocorrencia", "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/OcorrenciaAnual-Campinas_20260704_194108.csv")
	);
	
	public static List<CsvFile> findAllOcorrenciaFiles() {
		return ocorrenciaFiles;
	}
	
	public static List<CsvFile> findAllTaxaDelitoFiles() {
		return taxaDelitoFiles;
	}
			
}
