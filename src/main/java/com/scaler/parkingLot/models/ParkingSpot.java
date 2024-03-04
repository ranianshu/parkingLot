package com.scaler.parkingLot.models;

import java.util.List;

public class ParkingSpot extends BaseModel{
	
	private List<VehicleType> supportedVehicleTypes;
	private ParkingSpotStatus parkingSpotStatus;
	private int slotNumber;
	private ParkingFloor parkingFloor;

}
