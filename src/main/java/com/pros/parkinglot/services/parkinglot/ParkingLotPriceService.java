package com.pros.parkinglot.services.parkinglot;

import com.pros.parkinglot.models.vehicle.VehicleType;

public interface ParkingLotPriceService {

	ParkingLotPrice getPrice(VehicleType vehicleType);
}
