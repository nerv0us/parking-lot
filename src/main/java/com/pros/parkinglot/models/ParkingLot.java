package com.pros.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
@Getter
@Setter
public class ParkingLot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//TODO think about more fields here

}
