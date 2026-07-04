package com.umfrancisco.app.model;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CsvFile {
	
	@Id
	private Long id;
	private String fileName;
	private String url;
	private String cidade;
	
	public CsvFile() {
		
	}
	
	public CsvFile(String fileName, String url) {
		this.id = new Random().nextLong(Long.MAX_VALUE);
		this.fileName = fileName;
		this.url = url;
		this.cidade = cidadeFormatted();
	}
	
	public String cidadeFormatted() {
		String cidade = cidade().toLowerCase();
		cidade = cidade.replace(" ", "_");
		cidade = cidade.replace("ã", "a");
		return cidade;
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
		return "CsvFile [id=" + id + ", fileName=" + fileName + ", url=" + url + ", cidade=" + cidade + "]";
	}
	
}
