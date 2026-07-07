package com.umfrancisco.app.repository;

import java.util.List;
import com.umfrancisco.app.model.CsvFile;
import com.umfrancisco.app.util.Constants;

public class CrimeDatasetUrlFiles {
	
	private static String campinasOcorrencia = Constants.campinas+"-"+Constants.ocorrencia;
	private static String saoPauloOcorrencia = Constants.saoPaulo+"-"+Constants.ocorrencia;
	private static String saoPauloTaxaDelito = Constants.saoPaulo+"-"+Constants.taxaDelito;
	private static String campinasTaxaDelito = Constants.campinas+"-"+Constants.taxaDelito;
	private static String guarulhosTaxaDelito = Constants.guarulhos+"-"+Constants.taxaDelito;
	private static String saoBernardoTaxaDelito = Constants.saoBernardo+"-"+Constants.taxaDelito;
	private static String santoAndreTaxaDelito = Constants.santoAndre+"-"+Constants.taxaDelito;
	private static String osascoTaxaDelito = Constants.osasco+"-"+Constants.taxaDelito;
	private static String sorocabaTaxaDelito = Constants.sorocaba+"-"+Constants.taxaDelito;
	private static String santosTaxaDelito = Constants.santos+"-"+Constants.taxaDelito;
	private static String ribeiraoPretoTaxaDelito = Constants.ribeiraoPreto+"-"+Constants.taxaDelito;
	private static String saoJoseDosCamposTaxaDelito = Constants.saoJoseDosCampos+"-"+Constants.taxaDelito;
	
	private static List<CsvFile> taxaDelitoFiles = List.of(
			new CsvFile(saoPauloTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-S%C3%A3o%20Paulo_20260704_164249.csv"),
			new CsvFile(campinasTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-Campinas_20260704_194100.csv"),
			new CsvFile(guarulhosTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-Guarulhos_20260707_161733.csv"),
			new CsvFile(saoBernardoTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-S%C3%A3o%20Bernardo%20do%20Campo_20260707_161751.csv"),
			new CsvFile(santoAndreTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-Santo%20Andr%C3%A9_20260707_161804.csv"),
			new CsvFile(osascoTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-Osasco_20260707_161819.csv"),
			new CsvFile(sorocabaTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-Sorocaba_20260707_161831.csv"),
			new CsvFile(santosTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-Santos_20260707_161840.csv"),
			new CsvFile(ribeiraoPretoTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-Ribeir%C3%A3o%20Preto_20260707_161850.csv"),
			new CsvFile(saoJoseDosCamposTaxaDelito, "https://raw.githubusercontent.com/umfrancisco/api-securanca-publica-backend/refs/heads/main/data/TaxaDelito-S%C3%A3o%20Jos%C3%A9%20dos%20Campos_20260707_161856.csv")
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
