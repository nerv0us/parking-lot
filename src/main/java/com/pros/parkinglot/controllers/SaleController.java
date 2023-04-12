package com.pros.parkinglot.controllers;

import com.pros.parkinglot.models.sale.Sale;
import com.pros.parkinglot.services.sale.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

	private final SaleService saleService;

	@Autowired
	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@GetMapping("/report")
	public List<Sale> report(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
		return saleService.getSalesByDateRange(startDate, endDate);
	}

	@GetMapping("/monthlyReport")
	public List<Sale> monthlyReport(@RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth) {
		LocalDate startDate = yearMonth.atDay(1);
		LocalDate endDate = yearMonth.atEndOfMonth();
		return saleService.getSalesByDateRange(startDate, endDate);
	}
}