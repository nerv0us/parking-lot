package com.pros.parkinglot.services;

import com.pros.parkinglot.models.Sale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

	@Override
	public Sale create(Sale sale) {
		return null;
	}

	@Override
	public List<Sale> getSalesByDateRange(LocalDate startDate, LocalDate endDate) {
		return null;
	}
}
