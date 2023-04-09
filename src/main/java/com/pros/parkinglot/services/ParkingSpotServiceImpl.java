package com.pros.parkinglot.services;

import com.pros.parkinglot.models.VehicleType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParkingSpotServiceImpl implements ParkingSpotService {

	@Override
	public boolean checkHasAvailableSpot(VehicleType vehicleType) {
		return false;
	}

}
