package com.pros.parkinglot.services;

import com.pros.parkinglot.models.Ticket;
import com.pros.parkinglot.models.TicketStatus;
import com.pros.parkinglot.models.Vehicle;
import com.pros.parkinglot.models.VehicleType;
import com.pros.parkinglot.repositories.TicketRepository;
import com.pros.parkinglot.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class ParkingLotServiceImpl implements ParkingLotService {

	private final TicketRepository ticketRepository;
	private final VehicleRepository vehicleRepository;

	@Autowired
	public ParkingLotServiceImpl(TicketRepository ticketRepository, VehicleRepository vehicleRepository) {
		this.ticketRepository = ticketRepository;
		this.vehicleRepository = vehicleRepository;
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

	private static Vehicle getVehicle(String plateNumber, VehicleType vehicleType) {
		Vehicle vehicle = new Vehicle();
		vehicle.setPlateNumber(plateNumber);
		vehicle.setVehicleType(vehicleType);
		return vehicle;
	}
}
