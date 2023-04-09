package com.pros.parkinglot.services;

import java.math.BigDecimal;

class Price {

	private final BigDecimal pricePerHour;
	private final BigDecimal pricePerDay;
	private final Currency currency;

	private Price(Builder builder) {
		this.pricePerHour = builder.pricePerHour;
		this.pricePerDay = builder.pricePerDay;
		this.currency = builder.currency;
	}

	BigDecimal getPricePerHour() {
		return pricePerHour;
	}

	BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	Currency getCurrency() {
		return currency;
	}

	static class Builder {

		private BigDecimal pricePerHour;
		private BigDecimal pricePerDay;
		private Currency currency;

		Builder pricePerHour(BigDecimal price) {
			this.pricePerHour = price;
			return this;
		}

		Builder pricePerDay(BigDecimal price) {
			this.pricePerDay = price;
			return this;
		}

		Builder currency(Currency currency) {
			this.currency = currency;
			return this;
		}

		Price create() {
			return new Price(this);
		}
	}
}