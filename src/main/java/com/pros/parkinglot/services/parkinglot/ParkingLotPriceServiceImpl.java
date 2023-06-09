package com.pros.parkinglot.services.parkinglot;

import com.pros.parkinglot.enums.commons.Currency;
import com.pros.parkinglot.models.vehicle.VehicleType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParkingLotPriceServiceImpl implements ParkingLotPriceService {

	private static final Map<VehicleType, ParkingLotPrice> prices = new HashMap<>();

	static {
		prices.put(VehicleType.CAR, new ParkingLotPrice.Builder()
				.pricePerHour(BigDecimal.valueOf(1))
				.pricePerDay(BigDecimal.valueOf(10))
				.currency(Currency.EUR)
				.create());
		prices.put(VehicleType.BUS, new ParkingLotPrice.Builder()
				.pricePerHour(BigDecimal.valueOf(5))
				.pricePerDay(BigDecimal.valueOf(40))
				.currency(Currency.EUR)
				.create());
	}

	@Override
	public ParkingLotPrice getPrice(VehicleType vehicleType) {
		return prices.get(vehicleType);
	}

}
