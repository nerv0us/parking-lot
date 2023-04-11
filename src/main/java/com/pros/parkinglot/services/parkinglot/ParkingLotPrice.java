package com.pros.parkinglot.services.parkinglot;

import com.pros.parkinglot.enums.commons.Currency;

import java.math.BigDecimal;

public class ParkingLotPrice {

	private final BigDecimal pricePerHour;
	private final BigDecimal pricePerDay;
	private final Currency currency;

	private ParkingLotPrice(Builder builder) {
		this.pricePerHour = builder.pricePerHour;
		this.pricePerDay = builder.pricePerDay;
		this.currency = builder.currency;
	}

	public BigDecimal getPricePerHour() {
		return pricePerHour;
	}

	public BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	public Currency getCurrency() {
		return currency;
	}

	public static class Builder {

		private BigDecimal pricePerHour;
		private BigDecimal pricePerDay;
		private Currency currency;

		public Builder pricePerHour(BigDecimal price) {
			this.pricePerHour = price;
			return this;
		}

		public Builder pricePerDay(BigDecimal price) {
			this.pricePerDay = price;
			return this;
		}

		public Builder currency(Currency currency) {
			this.currency = currency;
			return this;
		}

		public ParkingLotPrice create() {
			return new ParkingLotPrice(this);
		}
	}
}