package com.scaler.parkingLot.strategies.spotAssignmentStrategies;

import com.scaler.parkingLot.models.SpotAssignmentStrategyType;

public class SpotAssignmentStrategyFactory {
	
	public static SpotAssignmentStrategy getSportAssignmentStrategyByType(SpotAssignmentStrategyType type) {
		if(type.equals(SpotAssignmentStrategyType.RANDOM)) {
			return new RandomSpotAssignmentStrategy();
		}
		return null;
	}

}
