package com.umfrancisco.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.app.model.TaxaDelito;

@Repository
public interface TaxaDelitoRepository extends JpaRepository<TaxaDelito, Long> {
	List<TaxaDelito> findByCidadeOrderByAnoAsc(String cidade);
	List<TaxaDelito> findByOrderByAnoAsc();
}
