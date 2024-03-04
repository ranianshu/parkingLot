package com.scaler.parkingLot.repositories;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import com.scaler.parkingLot.models.Vehicle;

public class VehicleRepository {
	
	private Map<String, Vehicle> vehicles = new HashMap<>();
	//private Long previousId = 0L;
	
	public Optional<Vehicle> getVehicleByNumber(String number){
		if(vehicles.containsKey(number)) {
			return Optional.of(vehicles.get(number));
		}
		return Optional.empty();
	}
	
	public Vehicle saveVehicle(Vehicle vehicle) {
		vehicles.put(vehicle.getNumber(), vehicle);
		return vehicle;
	}

}
