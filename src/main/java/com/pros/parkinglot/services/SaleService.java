package com.pros.parkinglot.services;

import com.pros.parkinglot.models.Sale;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {

	Sale create(Object sale);

	List<Sale> getSalesByDateRange(LocalDate startDate, LocalDate endDate);

}
