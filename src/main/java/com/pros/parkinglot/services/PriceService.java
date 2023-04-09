package com.pros.parkinglot.services;

import com.pros.parkinglot.models.VehicleType;

public interface PriceService {

	Price getPrice(VehicleType vehicleType);
}
