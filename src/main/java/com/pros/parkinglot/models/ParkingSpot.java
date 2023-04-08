package com.pros.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "parking_spot")
@Getter
@Setter
public class ParkingSpot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ParkingSpotState state;

}
