package com.pros.parkinglot.repositories;

import com.pros.parkinglot.models.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT s FROM Sale s WHERE s.date BETWEEN :startDate AND :endDate")
	List<Sale> findInRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
