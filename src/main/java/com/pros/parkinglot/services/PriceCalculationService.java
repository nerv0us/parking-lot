package com.pros.parkinglot.services;

import com.pros.parkinglot.models.Ticket;

interface PriceCalculationService {

	int calculatePrice(Ticket ticket);
}
