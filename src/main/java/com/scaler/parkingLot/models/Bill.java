package com.scaler.parkingLot.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
	
	private int amount;
	private Date exitTime;
	private Ticket ticket;
	private Gate gateGeneratedAt;
	private Operator generatedBy;
	private BillStatus billStatus;
	private List<Payment> payments;
	private List<FeeCalculatorStrategyType> feeCalculatorStrategyTypes;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getExitTime() {
		return exitTime;
	}
	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Gate getGateGeneratedAt() {
		return gateGeneratedAt;
	}
	public void setGateGeneratedAt(Gate gateGeneratedAt) {
		this.gateGeneratedAt = gateGeneratedAt;
	}
	public Operator getGeneratedBy() {
		return generatedBy;
	}
	public void setGeneratedBy(Operator generatedBy) {
		this.generatedBy = generatedBy;
	}
	public BillStatus getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(BillStatus billStatus) {
		this.billStatus = billStatus;
	}
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	public List<FeeCalculatorStrategyType> getFeeCalculatorStrategyTypes() {
		return feeCalculatorStrategyTypes;
	}
	public void setFeeCalculatorStrategyTypes(List<FeeCalculatorStrategyType> feeCalculatorStrategyTypes) {
		this.feeCalculatorStrategyTypes = feeCalculatorStrategyTypes;
	}

}
