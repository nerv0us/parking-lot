package com.pros.parkinglot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parking_lot")
@Getter
@Setter
public class ParkingLot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//TODO think about more fields here

}
