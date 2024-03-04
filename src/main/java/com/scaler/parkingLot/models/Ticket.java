package com.scaler.parkingLot.models;

import java.util.Date;

public class Ticket extends BaseModel{
	
	private String number;
	private Date entryTime;
	private Vehicle vehicle;
	private ParkingSpot assignedSpot;
	private Gate generatedAt;
	private Operator generatedBy;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public ParkingSpot getAssignedSpot() {
		return assignedSpot;
	}
	public void setAssignedSpot(ParkingSpot assignedSpot) {
		this.assignedSpot = assignedSpot;
	}
	public Gate getGeneratedAt() {
		return generatedAt;
	}
	public void setGeneratedAt(Gate generatedAt) {
		this.generatedAt = generatedAt;
	}
	public Operator getOperator() {
		return generatedBy;
	}
	public void setOperator(Operator generatedBy) {
		this.generatedBy = generatedBy;
	}

}
