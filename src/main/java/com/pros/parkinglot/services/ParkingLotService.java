package com.pros.parkinglot.services;

import com.pros.parkinglot.models.Sale;
import com.pros.parkinglot.models.Ticket;
import com.pros.parkinglot.models.VehicleType;

public interface ParkingLotService {


	Ticket enter(String plateNumber, VehicleType vehicleType);

	Sale exit(long ticketId);

}
