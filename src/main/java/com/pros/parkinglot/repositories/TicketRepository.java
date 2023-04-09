package com.pros.parkinglot.repositories;

import com.pros.parkinglot.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Ticket save(Ticket ticket);

}

