package com.pros.parkinglot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@NotNull
	private Vehicle vehicle;

	@NotNull
	private LocalDateTime entryTime;

	private LocalDateTime exitTime;

}
