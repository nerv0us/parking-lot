package com.pros.parkinglot.services.parkingspot;

import com.pros.parkinglot.models.vehicle.VehicleType;
import com.pros.parkinglot.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParkingSpotServiceImpl implements ParkingSpotService {

	ParkingSpotRepository parkingSpotRepository;

	@Autowired
	public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}

	@Override
	public int countAvailableSpots(VehicleType vehicleType) {
		return parkingSpotRepository.countAvailableByVehicleType(vehicleType);
	}

}
