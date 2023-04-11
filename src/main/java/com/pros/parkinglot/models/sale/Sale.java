package com.pros.parkinglot.models.sale;

import com.pros.parkinglot.models.ticket.Ticket;
import com.pros.parkinglot.models.vehicle.Vehicle;
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

	@OneToOne
	@NotNull
	private Vehicle vehicle;

	@NotNull
	private LocalDateTime date;

	@NotNull
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	private SaleStatus status;

}
