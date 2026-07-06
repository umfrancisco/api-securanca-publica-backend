package com.umfrancisco.app.model;

public class CsvFile {

	private String fileName;
	private String url;
	private String cidade;
	
	public CsvFile() {
		
	}
	
	public CsvFile(String fileName, String url) {
		this.fileName = fileName;
		this.url = url;
		this.cidade = cidade();
	}
	
	public String url() {
		return url;
	}
	public String cidade() {
		String[] infos = fileName.split("-");
		return infos[0];
	}
	public String tipo() {
		String[] infos = fileName.split("-");
		return infos[1];
	}

	@Override
	public String toString() {
		return "CsvFile [fileName=" + fileName + ", url=" + url + ", cidade=" + cidade + "]";
	}
	
}
