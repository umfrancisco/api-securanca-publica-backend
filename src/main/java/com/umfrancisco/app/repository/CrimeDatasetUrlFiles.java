package com.umfrancisco.app.repository;

import java.util.List;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.util.Constants;

public class CrimeDatasetUrlFiles {
	
	private static String saoPauloTaxaDelito = Constants.saoPaulo+"-"+Constants.taxaDelito;
	private static String saoPauloOcorrencia = Constants.saoPaulo+"-"+Constants.ocorrencia;
	private static String campinasTaxaDelito = Constants.campinas+"-"+Constants.taxaDelito;
	private static String campinasOcorrencia = Constants.campinas+"-"+Constants.ocorrencia;
	
	private static List<CsvFile> taxaDelitoFiles = List.of(
			new CsvFile(saoPauloTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-S%C3%A3o%20Paulo_20260704_164249.csv"),
			new CsvFile(campinasTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-Campinas_20260704_194100.csv")
	);
	
	private static List<CsvFile> ocorrenciaFiles = List.of(
			new CsvFile(saoPauloOcorrencia, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/OcorrenciaAnual-S%C3%A3o%20Paulo_20260704_164347.csv"),
			new CsvFile(campinasOcorrencia, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/OcorrenciaAnual-Campinas_20260704_194108.csv")
	);
	
	public static List<CsvFile> findAllOcorrenciaFiles() {
		return ocorrenciaFiles;
	}
	
	public static List<CsvFile> findAllTaxaDelitoFiles() {
		return taxaDelitoFiles;
	}
			
}
