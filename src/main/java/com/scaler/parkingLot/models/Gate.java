package com.scaler.parkingLot.models;

public class Gate extends BaseModel{
	
	private GateType gateTypes;
	private int gateNumber;
	private Operator operator;
	private GateStatus gateStatus;
	
	public GateType getGateTypes() {
		return gateTypes;
	}
	public void setGateTypes(GateType gateTypes) {
		this.gateTypes = gateTypes;
	}
	public int getGateNumber() {
		return gateNumber;
	}
	public void setGateNumber(int gateNumber) {
		this.gateNumber = gateNumber;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public GateStatus getGateStatus() {
		return gateStatus;
	}
	public void setGateStatus(GateStatus gateStatus) {
		this.gateStatus = gateStatus;
	}

}
