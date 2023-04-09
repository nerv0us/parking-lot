package com.pros.parkinglot.services;

import com.pros.parkinglot.models.Ticket;
import com.pros.parkinglot.models.VehicleType;

public interface ParkingLotService {


	Ticket enter(String plateNumber, VehicleType vehicleType);

}
