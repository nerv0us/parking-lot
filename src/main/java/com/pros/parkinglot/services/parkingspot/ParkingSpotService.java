package com.pros.parkinglot.services.parkingspot;

import com.pros.parkinglot.models.vehicle.VehicleType;

public interface ParkingSpotService {

	int countAvailableSpots(VehicleType vehicleType);

}
