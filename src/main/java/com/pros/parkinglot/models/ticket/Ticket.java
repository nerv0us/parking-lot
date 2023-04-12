package com.pros.parkinglot.models.ticket;

import com.pros.parkinglot.models.vehicle.Vehicle;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@NotNull
	private Vehicle vehicle;

	@NotNull
	private LocalDateTime entryTime;

	private LocalDateTime exitTime;

	@Enumerated(EnumType.STRING)
	private TicketStatus status;

	public Ticket() {

	}

}
