package com.pros.parkinglot.services.sale;

import com.pros.parkinglot.models.sale.Sale;
import com.pros.parkinglot.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

	private final SaleRepository saleRepository;

	@Autowired
	public SaleServiceImpl(SaleRepository saleRepository) {
		this.saleRepository = saleRepository;
	}

	@Override
	public List<Sale> getSalesByDateRange(LocalDate startDate, LocalDate endDate) {
		LocalDateTime startDateTime = LocalDateTime.of(startDate, LocalDateTime.MIN.toLocalTime());
		LocalDateTime endDateTime = LocalDateTime.of(endDate, LocalDateTime.MAX.toLocalTime());
		return saleRepository.findInRange(startDateTime, endDateTime);
	}
}