package com.pros.parkinglot.controllers;

import com.pros.parkinglot.models.Sale;
import com.pros.parkinglot.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class SaleController {

	private final SaleService saleService;

	@Autowired
	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@GetMapping("/sales")
	public List<Sale> getSales(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
		return null;
	}
}

