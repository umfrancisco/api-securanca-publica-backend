package com.umfrancisco.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.umfrancisco.app.util.TaxaDelitoCsvParser;

@Configuration
public class BeansConfig {
	
	@Bean
	public TaxaDelitoCsvParser taxaDelitoCsvParser() {
		return new TaxaDelitoCsvParser();
	}
	
}
