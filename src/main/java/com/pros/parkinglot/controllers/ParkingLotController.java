package com.pros.parkinglot.controllers;

import com.pros.parkinglot.models.Ticket;
import com.pros.parkinglot.models.Vehicle;
import com.pros.parkinglot.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/parking")
public class ParkingLotController {

	private final ParkingLotService parkingLotService;

	@Autowired
	public ParkingLotController(ParkingLotService parkingLotService) {
		this.parkingLotService = parkingLotService;
	}

	@PostMapping("/enter")
	public ResponseEntity<Ticket> enter(@RequestParam Vehicle vehicle) {
		return ResponseEntity.ok(null);
	}

	@PostMapping("/exit")
	public ResponseEntity<BigDecimal> exit(@RequestParam Long id) {
		return ResponseEntity.ok(null);
	}
}

