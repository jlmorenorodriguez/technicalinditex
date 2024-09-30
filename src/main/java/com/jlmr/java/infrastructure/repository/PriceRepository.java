package com.jlmr.java.infrastructure.repository;

import org.springframework.stereotype.Repository;

import com.jlmr.java.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

	@Query("""
			SELECT p FROM Price p
			JOIN p.brand b
			WHERE b.id = ?1 AND p.productId = ?2 AND (?3 BETWEEN p.startDate AND p.endDate)
			ORDER BY p.priority ASC
			""")
	List<Price> findByBrandProductAndDate(Long brandId, Long productId, LocalDateTime appDate);

}
