package com.umfrancisco.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CsvFile {
	
	@Id
	private Long id;
	private String fileName;
	private String url;
	
	public CsvFile() {
		
	}
	
	public CsvFile(String fileName, String url) {
		this.fileName = fileName;
		this.url = url;
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
		return "CsvFile [id=" + id + ", fileName=" + fileName + ", url=" + url + "]";
	}
}
