package com.pros.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	@NotNull(message = "Plate number is required")
	@Pattern(regexp = "^[A-Z0-9-]*$")
	private String plateNumber;

	@OneToOne
	private Ticket ticket;

}
