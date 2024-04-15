package com.tales.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tales.restapi.entity.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

}
