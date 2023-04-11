package com.pros.parkinglot.repositories;

import com.pros.parkinglot.models.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	Vehicle save(Vehicle ticket);

}

