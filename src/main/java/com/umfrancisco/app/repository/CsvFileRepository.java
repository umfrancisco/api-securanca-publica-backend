package com.umfrancisco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.app.model.CsvFile;

@Repository
public interface CsvFileRepository extends JpaRepository<CsvFile, Long> {
	
}
