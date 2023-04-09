package com.pros.parkinglot.repositories;

import com.pros.parkinglot.models.ParkingSpot;
import com.pros.parkinglot.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

	@Query("SELECT COUNT(p) FROM ParkingSpot p WHERE p.vehicleType = :vehicleType AND p.state = 'AVAILABLE'")
	int countAvailableByVehicleType(@Param("vehicleType") VehicleType vehicleType);

}

