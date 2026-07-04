package com.umfrancisco.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.umfrancisco.app.util.OcorrenciaCsvParser;

@Configuration
public class BeansConfig {
	
	@Bean
	public OcorrenciaCsvParser ocorrenciaCsvParser() {
		return new OcorrenciaCsvParser();
	}
	
}
