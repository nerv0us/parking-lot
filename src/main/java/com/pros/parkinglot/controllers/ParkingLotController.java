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
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/parkingSpots")
	public ResponseEntity<Integer> getParkingSpots(@RequestParam @NotBlank @Pattern(regexp = "^(bus|car)$") String vehicleType) {
		int availableSpots = getAvailableSpots(vehicleType);
		return ResponseEntity.ok().body(availableSpots);
	}

	@PostMapping("/enter")
	public ResponseEntity<Optional<Ticket>> enter(
			@RequestParam @NotBlank @Pattern(regexp = "^[A-Z0-9-]*$") String plateNumber,
			@RequestParam @NotBlank @Pattern(regexp = "^(bus|car)$") String vehicleType) {
		int availableSpots = getAvailableSpots(vehicleType);
		if (availableSpots > 0) {
			Ticket ticket = parkingLotService.enter(plateNumber, VehicleType.valueOf(vehicleType.toUpperCase()));
			return ResponseEntity.ok().body(Optional.of(ticket));
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(Optional.empty());
	}

	@PostMapping("/exit")
	public Sale exit(@RequestParam @NotBlank Long ticketId) {
		// Calculate the sale total based on the parking duration and vehicle type
		// Save the sale record in the database and free up the parking spot
		return null;
	}

	private int getAvailableSpots(String vehicleType) {
		VehicleType vehicleTypeAsEnum = VehicleType.valueOf(vehicleType.toUpperCase());
		return parkingSpotService.countAvailableSpots(vehicleTypeAsEnum);
	}
}

