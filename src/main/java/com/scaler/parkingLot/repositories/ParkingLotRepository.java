package com.scaler.parkingLot.repositories;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import com.scaler.parkingLot.models.Gate;
import com.scaler.parkingLot.models.ParkingLot;

public class ParkingLotRepository {
	
	private Map<Long, ParkingLot> parkingLotMap = new HashMap<>();
	
	public ParkingLot getParkingLotByGate(Gate gate){
		for(ParkingLot parkingLot: parkingLotMap.values()) {
			if(parkingLot.getGates().contains(gate)) {
				return parkingLot;
			}
		}
		return null;
	}

}
