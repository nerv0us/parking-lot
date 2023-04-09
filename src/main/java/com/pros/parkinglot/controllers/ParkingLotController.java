package com.pros.parkinglot.controllers;

import com.pros.parkinglot.models.Sale;
import com.pros.parkinglot.models.Ticket;
import com.pros.parkinglot.models.VehicleType;
import com.pros.parkinglot.services.ParkingLotService;
import com.pros.parkinglot.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/parking")
public class ParkingLotController {

	private final ParkingLotService parkingLotService;
	private final ParkingSpotService parkingSpotService;

	@Autowired
	public ParkingLotController(ParkingLotService parkingLotService, ParkingSpotService parkingSpotService) {
		this.parkingLotService = parkingLotService;
		this.parkingSpotService = parkingSpotService;
	}

	@PostMapping("/enter")
	public ResponseEntity<Optional<Ticket>> enter(
			@RequestParam @NotBlank @Pattern(regexp = "^[A-Z0-9-]*$") String plateNumber,
			@RequestParam @NotBlank @Pattern(regexp = "^(bus|car)$") String vehicleType) {
		boolean hasAvailableSpot = parkingSpotService.checkHasAvailableSpot(VehicleType.valueOf(vehicleType.toUpperCase()));
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

