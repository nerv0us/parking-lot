package com.pros.parkinglot.services.sale;

import com.pros.parkinglot.models.sale.Sale;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {

	List<Sale> getSalesByDateRange(LocalDate startDate, LocalDate endDate);

}
