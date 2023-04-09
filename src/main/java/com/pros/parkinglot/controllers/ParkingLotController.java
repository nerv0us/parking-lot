package com.pros.parkinglot.controllers;

import com.pros.parkinglot.models.Sale;
import com.pros.parkinglot.models.Ticket;
import com.pros.parkinglot.models.VehicleType;
import com.pros.parkinglot.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/parking")
public class ParkingLotController {

	private final ParkingLotService parkingLotService;

	@Autowired
	public ParkingLotController(ParkingLotService parkingLotService) {
		this.parkingLotService = parkingLotService;
	}

	@PostMapping("/enter")
	public ResponseEntity<Optional<Ticket>> enter(
			@RequestParam @Pattern(regexp = "^[A-Z0-9-]*$") String plateNumber,
			@RequestParam @Pattern(regexp = "^(bus|car)$") String vehicleType) {
		boolean hasAvailableSpot = parkingLotService.checkIfSpotIsAvailable(VehicleType.valueOf(vehicleType.toUpperCase()));
		return hasAvailableSpot
				? ResponseEntity.ok().body(Optional.of(parkingLotService.enter(plateNumber)))
				: ResponseEntity.status(HttpStatus.CONFLICT).body(Optional.empty());
	}

	@PostMapping("/exit")
	public Sale exit(@RequestParam Long id) {
		// Calculate the sale total based on the parking duration and vehicle type
		// Save the sale record in the database and free up the parking spot
		return null;
	}

	private static VehicleType convertToVehicleType(String vehicleType) {
		return VehicleType.valueOf(vehicleType.toUpperCase());
	}
}

