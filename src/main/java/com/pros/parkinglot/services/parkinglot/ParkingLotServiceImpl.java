package com.pros.parkinglot.services.parkinglot;

import com.pros.parkinglot.models.sale.Sale;
import com.pros.parkinglot.models.ticket.Ticket;
import com.pros.parkinglot.models.ticket.TicketStatus;
import com.pros.parkinglot.models.vehicle.Vehicle;
import com.pros.parkinglot.models.vehicle.VehicleType;
import com.pros.parkinglot.repositories.TicketRepository;
import com.pros.parkinglot.repositories.VehicleRepository;
import com.pros.parkinglot.services.parkingrate.ParkingRateCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class ParkingLotServiceImpl implements ParkingLotService {

	private final TicketRepository ticketRepository;
	private final VehicleRepository vehicleRepository;
	private final ParkingRateCalculatorService parkingRateCalculatorService;

	@Autowired
	public ParkingLotServiceImpl(TicketRepository ticketRepository,
			VehicleRepository vehicleRepository,
			ParkingRateCalculatorService parkingRateCalculatorService) {
		this.ticketRepository = ticketRepository;
		this.vehicleRepository = vehicleRepository;
		this.parkingRateCalculatorService = parkingRateCalculatorService;
	}

	@Override
	public Ticket enter(String plateNumber, VehicleType vehicleType) {
		Ticket ticket = new Ticket();
		ticket.setEntryTime(LocalDateTime.now());
		ticket.setStatus(TicketStatus.ACTIVE);
		Vehicle vehicle = getVehicle(plateNumber, vehicleType);
		ticket.setVehicle(vehicle);

		vehicleRepository.save(vehicle);
		return ticketRepository.save(ticket);
	}

	@Override
	public Sale exit(long ticketId) {
		Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
		if (ticketOptional.isPresent()) {
			Ticket ticket = updateTicketExitTime(ticketOptional.get());
			BigDecimal parkingRateAmount = parkingRateCalculatorService.calculateParkingRateAmount(ticket);
			Sale sale = new Sale();
			sale.setTicket(ticket);
			sale.setAmount(parkingRateAmount);
			return sale;
		}
		return null;
	}

	private Ticket updateTicketExitTime(Ticket ticket) {
		ticket.setExitTime(LocalDateTime.now());
		return ticketRepository.save(ticket);
	}

	private Vehicle getVehicle(String plateNumber, VehicleType vehicleType) {
		Vehicle vehicle = new Vehicle();
		vehicle.setPlateNumber(plateNumber);
		vehicle.setVehicleType(vehicleType);
		return vehicle;
	}

}
