package com.pros.parkinglot.services;

import com.pros.parkinglot.models.Ticket;

import java.math.BigDecimal;

interface ParkingRateCalculatorService {

	BigDecimal calculateParkingRateAmount(Ticket ticket);
}
