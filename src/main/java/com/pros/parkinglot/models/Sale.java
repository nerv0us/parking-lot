package com.pros.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale")
@Getter
@Setter
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@NotNull
	private Ticket ticket;

	@NotNull
	private LocalDateTime date;

	@NotNull
	private BigDecimal amount;

}
