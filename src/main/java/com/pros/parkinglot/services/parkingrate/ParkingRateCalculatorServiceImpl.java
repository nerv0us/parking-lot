package com.pros.parkinglot.services.parkingrate;

import com.pros.parkinglot.models.ticket.Ticket;
import com.pros.parkinglot.models.vehicle.Vehicle;
import com.pros.parkinglot.models.vehicle.VehicleType;
import com.pros.parkinglot.repositories.VehicleRepository;
import com.pros.parkinglot.services.parkinglot.ParkingLotPrice;
import com.pros.parkinglot.services.parkinglot.ParkingLotPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class ParkingRateCalculatorServiceImpl implements ParkingRateCalculatorService {

	private final ParkingLotPriceService parkingLotPriceService;
	private final VehicleRepository vehicleRepository;

	@Autowired
	public ParkingRateCalculatorServiceImpl(ParkingLotPriceService parkingLotPriceService, VehicleRepository vehicleRepository) {
		this.parkingLotPriceService = parkingLotPriceService;
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public BigDecimal calculateParkingRateAmount(Ticket ticket) {
		Duration duration = getParkingDuration(ticket);
		VehicleType vehicleType = getVehicleType(ticket);
		ParkingLotPrice parkingLotPrice = parkingLotPriceService.getPrice(vehicleType);
		long durationHours = getDurationHours(duration);
		return durationHours < ParkingRateCalculatorConstants.HOURS_IN_DAY
				? calculateSingleDayAmount(durationHours, parkingLotPrice)
				: calculateMultipleDaysAmount(durationHours, parkingLotPrice);
	}

	private Duration getParkingDuration(Ticket ticket) {
		LocalDateTime entryTime = ticket.getEntryTime();
		LocalDateTime endTime = ticket.getExitTime();
		return Duration.between(entryTime, endTime);
	}

	private VehicleType getVehicleType(Ticket ticket) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(ticket.getVehicle().getId());
		return vehicle.map(Vehicle::getVehicleType).orElse(null);
	}

	private long getDurationHours(Duration duration) {
		long hours = duration.toHours();
		long minutes = duration.toMinutes();
		long minutesInCurrentHour = minutes - (hours * ParkingRateCalculatorConstants.MINUTES_IN_HOUR);
		if (minutesInCurrentHour > 0) {
			hours++;
		}
		return hours;
	}

	private BigDecimal calculateSingleDayAmount(long durationHours, ParkingLotPrice parkingLotPrice) {
		BigDecimal vehiclePricePerHour = parkingLotPrice.getPricePerHour();
		return vehiclePricePerHour.multiply(BigDecimal.valueOf(durationHours));
	}

	private BigDecimal calculateMultipleDaysAmount(long durationHours, ParkingLotPrice parkingLotPrice) {
		BigDecimal vehiclePricePerDay = parkingLotPrice.getPricePerDay();
		BigDecimal pricePerDays = calculatePricePerDays(vehiclePricePerDay, durationHours);
		BigDecimal vehiclePricePerHour = parkingLotPrice.getPricePerHour();
		BigDecimal pricePerHours = calculatePricePerHours(vehiclePricePerHour, durationHours);
		return pricePerDays.add(pricePerHours);
	}

	private BigDecimal calculatePricePerDays(BigDecimal vehiclePricePerDay, long durationHours) {
		long durationDays = durationHours / ParkingRateCalculatorConstants.HOURS_IN_DAY;
		return vehiclePricePerDay.multiply(BigDecimal.valueOf(durationDays));
	}

	private BigDecimal calculatePricePerHours(BigDecimal vehiclePricePerHour, long durationHours) {
		long remainingHours = durationHours % ParkingRateCalculatorConstants.HOURS_IN_DAY;
		return vehiclePricePerHour.multiply(BigDecimal.valueOf(remainingHours));
	}
}