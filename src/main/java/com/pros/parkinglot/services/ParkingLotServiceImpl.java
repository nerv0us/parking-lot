package com.pros.parkinglot.services;

import com.pros.parkinglot.models.Ticket;
import com.pros.parkinglot.models.Vehicle;
import com.pros.parkinglot.models.VehicleType;
import com.pros.parkinglot.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class ParkingLotServiceImpl implements ParkingLotService {

	private final TicketRepository ticketRepository;

	@Autowired
	public ParkingLotServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public Ticket enter(String plateNumber, VehicleType vehicleType) {
		Ticket ticket = new Ticket();
		ticket.setEntryTime(LocalDateTime.now());
		Vehicle vehicle = new Vehicle();
		vehicle.setPlateNumber(plateNumber);
		ticket.setVehicle(vehicle);
		return ticketRepository.save(ticket);
	}
}
