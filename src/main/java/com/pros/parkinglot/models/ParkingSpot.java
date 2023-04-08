package com.pros.parkinglot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parking_spots")
@Getter
@Setter
public class ParkingSpot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ParkingSpotState state;

}
