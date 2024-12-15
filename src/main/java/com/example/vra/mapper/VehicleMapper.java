package com.example.vra.mapper;

import org.springframework.stereotype.Component;

import com.example.vra.entity.Vehicle;
import com.example.vra.requestdto.VehicleRequest;
import com.example.vra.responsedto.VehicleResponse;

@Component
public class VehicleMapper {

    public Vehicle mapToVehicle(VehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        if (vehicleRequest.getManufacturer() != null) {
            vehicle.setManufacturer(vehicleRequest.getManufacturer());
        }
        if (vehicleRequest.getModel() != null) {
            vehicle.setModel(vehicleRequest.getModel());
        }
        if (vehicleRequest.getVehicleType() != null) {
            vehicle.setVehicleType(vehicleRequest.getVehicleType());
        }
        if (vehicleRequest.getFuelType() != null) {
            vehicle.setFuelType(vehicleRequest.getFuelType());
        }
        return vehicle;
    }

    public VehicleResponse mapToResponse(Vehicle vehicle) {
        VehicleResponse response = new VehicleResponse();
        response.setVehicleId(vehicle.getVehicleId());
        response.setManufacturer(vehicle.getManufacturer());
        response.setModel(vehicle.getModel());
        response.setVehicleType(vehicle.getVehicleType());
        response.setFuelType(vehicle.getFuelType());
        return response;
    }
}