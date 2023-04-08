package com.pros.parkinglot.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@NotNull
	private Vehicle vehicle;

	@NotNull
	private LocalDateTime entryTime;

	private LocalDateTime exitTime;

}
