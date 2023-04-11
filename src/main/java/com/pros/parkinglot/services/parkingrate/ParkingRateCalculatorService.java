package com.pros.parkinglot.services.parkingrate;

import com.pros.parkinglot.models.ticket.Ticket;

import java.math.BigDecimal;

public interface ParkingRateCalculatorService {

	BigDecimal calculateParkingRateAmount(Ticket ticket);
}
