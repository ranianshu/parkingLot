package com.scaler.parkingLot.strategies.spotAssignmentStrategies;

import com.scaler.parkingLot.models.Gate;
import com.scaler.parkingLot.models.ParkingSpot;
import com.scaler.parkingLot.models.VehicleType;

public interface SpotAssignmentStrategy {
	
	public ParkingSpot getSpot(Gate gate, VehicleType vehicleType);

}
