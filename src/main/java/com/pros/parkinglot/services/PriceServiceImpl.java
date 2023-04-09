package com.pros.parkinglot.services;

import com.pros.parkinglot.models.VehicleType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class PriceServiceImpl implements PriceService {

	private static final Map<VehicleType, Price> prices = new HashMap<>();

	static {
		prices.put(VehicleType.CAR, new Price.Builder()
				.pricePerHour(BigDecimal.valueOf(1))
				.pricePerDay(BigDecimal.valueOf(10))
				.currency(Currency.EUR)
				.create());
	}

	@Override
	public Price getPrice(VehicleType vehicleType) {
		return prices.get(vehicleType);
	}

}
