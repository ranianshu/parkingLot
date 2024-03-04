package com.scaler.parkingLot.models;

import java.util.List;

public class ParkingFloor extends BaseModel{
	
	private List<ParkingSpot> parkingSlots;
	private int floorNumber;
	
	public List<ParkingSpot> getParkingSlots() {
		return parkingSlots;
	}
	public void setParkingSlots(List<ParkingSpot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

}
