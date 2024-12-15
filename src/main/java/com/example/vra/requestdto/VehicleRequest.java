package com.example.vra.requestdto;

import com.example.vra.enums.FuelType;
import com.example.vra.enums.VehicleType;

public class VehicleRequest {

	private String manufacturer;
	private String model;
	private VehicleType vehicleType;
	private FuelType fuelType;


	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType( FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}
