package com.pros.parkinglot.services;

import com.pros.parkinglot.models.Ticket;
import com.pros.parkinglot.models.Vehicle;
import com.pros.parkinglot.models.VehicleType;
import com.pros.parkinglot.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
class PriceCalculationServiceImpl implements PriceCalculationService {

	private final VehicleRepository vehicleRepository;
	private final PriceService priceService;

	@Autowired
	PriceCalculationServiceImpl(VehicleRepository vehicleRepository, PriceService priceService) {
		this.vehicleRepository = vehicleRepository;
		this.priceService = priceService;
	}

	@Override
	public int calculatePrice(Ticket ticket) {
		LocalDateTime entryTime = ticket.getEntryTime();
		LocalDateTime endTime = ticket.getExitTime();
		Optional<Vehicle> vehicle = vehicleRepository.findById(ticket.getVehicle().getId());
		VehicleType vehicleType = vehicle.get().getVehicleType();
		Price price = priceService.getPrice(vehicleType);
		BigDecimal pricePerHour = price.getPricePerHour();
		BigDecimal pricePerDay = price.getPricePerDay();
		int calculatedPrice = 0;
		return calculatedPrice;
	}
}