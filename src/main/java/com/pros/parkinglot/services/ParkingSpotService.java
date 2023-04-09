package com.pros.parkinglot.services;

import com.pros.parkinglot.models.VehicleType;

public interface ParkingSpotService {

	int countAvailableSpots(VehicleType vehicleType);

}
