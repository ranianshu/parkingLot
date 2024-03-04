package com.scaler.parkingLot.repositories;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import com.scaler.parkingLot.models.Gate;

public class GateRepository{
	
	private Map<Long, Gate> gates = new HashMap<>();
	
	public Optional<Gate> getGateById(Long id){
		if(gates.containsKey(id)) {
			return Optional.of(gates.get(id));
		}
		return Optional.empty();
	}

}
