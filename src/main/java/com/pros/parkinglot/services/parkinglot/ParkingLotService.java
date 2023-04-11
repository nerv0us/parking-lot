package com.pros.parkinglot.services.parkinglot;

import com.pros.parkinglot.models.sale.Sale;
import com.pros.parkinglot.models.ticket.Ticket;
import com.pros.parkinglot.models.vehicle.VehicleType;

public interface ParkingLotService {


	Ticket enter(String plateNumber, VehicleType vehicleType);

	Sale exit(long ticketId);

}
