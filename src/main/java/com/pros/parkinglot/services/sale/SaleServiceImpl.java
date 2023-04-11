package com.pros.parkinglot.services.sale;

import com.pros.parkinglot.models.sale.Sale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

	@Override
	public Sale create(Object sale) {
		return null;
	}

	@Override
	public List<Sale> getSalesByDateRange(LocalDate startDate, LocalDate endDate) {
		List<Sale> sales = new ArrayList<>();
//		Sale sale = new Sale();
//		sale.setId(1L);
//		sale.setAmount(new BigDecimal(100));
//		Ticket ticket = new Ticket();
//		ticket.setId(2L);
//		sale.setTicket(ticket);
//		sales.add(sale);
		return sales;
	}
}
