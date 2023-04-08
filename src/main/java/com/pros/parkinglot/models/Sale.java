package com.pros.parkinglot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@NotNull
	private Ticket ticket;

	@NotNull
	private LocalDateTime date;

	@NotNull
	private BigDecimal price;

}
