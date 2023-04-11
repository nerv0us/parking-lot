package com.pros.parkinglot.controllers;

import com.pros.parkinglot.models.sale.Sale;
import com.pros.parkinglot.services.sale.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

	private final SaleService saleService;

	@Autowired
	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@PostMapping("/create")
	public Sale create(@RequestBody Sale sale) {
		return saleService.create(sale);
	}

	@GetMapping("/report")
	public List<Sale> report(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
		return saleService.getSalesByDateRange(startDate, endDate);
	}

	//	@GetMapping("/report")
	//	public List<Sale> monthlyReport(@RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth) {
	//		LocalDate startDate = yearMonth.atDay(1);
	//		LocalDate endDate = yearMonth.atEndOfMonth();
	//		return saleService.getSalesByDateRange(startDate, endDate);
	//	}
}

