package com.pros.parkinglot.services.parkingrate;

import com.pros.parkinglot.models.ticket.Ticket;
import com.pros.parkinglot.models.ticket.TicketStatus;
import com.pros.parkinglot.models.vehicle.Vehicle;
import com.pros.parkinglot.models.vehicle.VehicleType;
import com.pros.parkinglot.repositories.VehicleRepository;
import com.pros.parkinglot.services.parkinglot.ParkingLotPriceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ParkingRateCalculatorServiceTest {

	@Mock
	private VehicleRepository vehicleRepository;
	@Mock
	private ParkingLotPriceServiceImpl parkingLotPriceService;
	@InjectMocks
	private ParkingRateCalculatorServiceImpl parkingRateCalculatorService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.parkingLotPriceService = new ParkingLotPriceServiceImpl();
		this.parkingRateCalculatorService = new ParkingRateCalculatorServiceImpl(parkingLotPriceService, vehicleRepository);
	}

	@Test
	void testCalculateParkingRateAmountForBusForSingleDay() {
		Ticket ticket = createTicketWithDuration(Duration.ofHours(10));
		Vehicle mockVehicle = getVehicleFromType(VehicleType.BUS);
		when(vehicleRepository.findById(1L)).thenReturn(Optional.of(mockVehicle));

		BigDecimal result = parkingRateCalculatorService.calculateParkingRateAmount(ticket);

		assertEquals(BigDecimal.valueOf(50), result);
	}

	@Test
	void testCalculateParkingRateAmountForCarForSingleDay() {
		Ticket ticket = createTicketWithDuration(Duration.ofHours(10));
		Vehicle mockVehicle = getVehicleFromType(VehicleType.CAR);
		when(vehicleRepository.findById(1L)).thenReturn(Optional.of(mockVehicle));

		BigDecimal result = parkingRateCalculatorService.calculateParkingRateAmount(ticket);

		assertEquals(BigDecimal.valueOf(10), result);
	}

	@Test
	void testCalculateParkingRateAmountForCarForMultipleDays() {
		Ticket ticket = createTicketWithDuration(Duration.ofHours(30));
		Vehicle mockVehicle = getVehicleFromType(VehicleType.CAR);
		when(vehicleRepository.findById(1L)).thenReturn(Optional.of(mockVehicle));

		BigDecimal result = parkingRateCalculatorService.calculateParkingRateAmount(ticket);

		assertEquals(BigDecimal.valueOf(16), result);
	}

	@Test
	void testCalculateParkingRateAmountForBusForMultipleDays() {
		Ticket ticket = createTicketWithDuration(Duration.ofHours(30));
		Vehicle mockVehicle = getVehicleFromType(VehicleType.BUS);
		when(vehicleRepository.findById(1L)).thenReturn(Optional.of(mockVehicle));

		BigDecimal result = parkingRateCalculatorService.calculateParkingRateAmount(ticket);

		assertEquals(BigDecimal.valueOf(70), result);
	}

	private Ticket createTicketWithDuration(Duration duration) {
		LocalDateTime entryTime = LocalDateTime.now();
		LocalDateTime exitTime = entryTime.plus(duration);
		Vehicle vehicle = getVehicleFromType(VehicleType.BUS);
		return new Ticket(1L, vehicle, entryTime, exitTime, TicketStatus.ACTIVE);
	}

	private Vehicle getVehicleFromType(VehicleType vehicleType) {
		return new Vehicle(1L, vehicleType, "TX3274");
	}
}
