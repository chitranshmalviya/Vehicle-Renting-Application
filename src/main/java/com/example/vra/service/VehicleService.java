package com.example.vra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vra.entity.Vehicle;
import com.example.vra.exception.VehicleNotFoundByIdException;
import com.example.vra.mapper.VehicleMapper;
import com.example.vra.repository.VehicleRepository;
import com.example.vra.requestdto.VehicleRequest;
import com.example.vra.responsedto.VehicleResponse;

@Service
public class VehicleService {
	
	private final VehicleRepository vehicleRepository;
	private final VehicleMapper vehicleMapper;

	public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
		this.vehicleRepository = vehicleRepository;
		this.vehicleMapper = vehicleMapper;
	}
	
    public VehicleResponse register(VehicleRequest vehicleRequest) {
        Vehicle vehicle = vehicleMapper.mapToVehicle(vehicleRequest);
        Vehicle savedVehicle = vehicleRepository.save(vehicle); 
        return vehicleMapper.mapToResponse(savedVehicle); 
    }
	
	public List<VehicleResponse> findAllVehicles() {

		List<Vehicle> vehicles = vehicleRepository.findAll();
		List<VehicleResponse> vehicleResponses = new ArrayList<VehicleResponse>();
		for (Vehicle vehicle : vehicles) {
			VehicleResponse response = vehicleMapper.mapToResponse(vehicle);
			vehicleResponses.add(response);
		}
		return vehicleResponses;
	}

	public VehicleResponse updateVehicleById(int vehicleId, VehicleRequest request) {

		Vehicle existingVehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new VehicleNotFoundByIdException("Vehicle not found"));
		existingVehicle.setManufacturer(request.getManufacturer());
		existingVehicle.setModel(request.getModel());
		existingVehicle.setFuelType(request.getFuelType()); 
		
		Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
		return vehicleMapper.mapToResponse(updatedVehicle);
	}

}
