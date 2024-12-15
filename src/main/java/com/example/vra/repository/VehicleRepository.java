package com.example.vra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vra.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
