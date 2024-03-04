package com.scaler.parkingLot.services;

import java.util.Date;
import java.util.Optional;

import com.scaler.parkingLot.exceptions.GateNotFoundException;
import com.scaler.parkingLot.models.Gate;
import com.scaler.parkingLot.models.ParkingLot;
import com.scaler.parkingLot.models.SpotAssignmentStrategyType;
import com.scaler.parkingLot.models.Ticket;
import com.scaler.parkingLot.models.Vehicle;
import com.scaler.parkingLot.models.VehicleType;
import com.scaler.parkingLot.repositories.GateRepository;
import com.scaler.parkingLot.repositories.ParkingLotRepository;
import com.scaler.parkingLot.repositories.TicketRepository;
import com.scaler.parkingLot.repositories.VehicleRepository;
import com.scaler.parkingLot.strategies.spotAssignmentStrategies.SpotAssignmentStrategy;
import com.scaler.parkingLot.strategies.spotAssignmentStrategies.SpotAssignmentStrategyFactory;

public class TicketService {
	
	private GateRepository gateRepository;
	private VehicleRepository vehicleRepository;
	private ParkingLotRepository parkingLotRepository;
	private TicketRepository ticketRepository;
	
	public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
		this.gateRepository = gateRepository;
		this.vehicleRepository = vehicleRepository;
		this.parkingLotRepository = parkingLotRepository;
		this.ticketRepository = ticketRepository;
	}
	
	public Ticket issueTicket(VehicleType vehicleType, String vehicleNumber, String vehicleOwnerName, Long gateId) throws GateNotFoundException {
		//create Ticket object
		Ticket ticket = new Ticket();
		ticket.setEntryTime(new Date());
		
		//set up gate for my ticket
		Optional<Gate> gateOptional = gateRepository.getGateById(gateId);
		if(gateOptional.isEmpty()) {
			throw new GateNotFoundException();
		}
		Gate gate = gateOptional.get();
		ticket.setGeneratedAt(gate);
		ticket.setOperator(gate.getOperator());
		
		 //check if vehicle in database
        //1. yes ->
        // get vehicle from database
        // put in ticket object
        //2. no ->
        // create object of vehicle and save in database
        // put in database
		
		Optional<Vehicle> vehicleOptional = vehicleRepository.getVehicleByNumber(vehicleNumber);
		Vehicle savedVehicle;
		if(vehicleOptional.isEmpty()) {
			Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType, vehicleOwnerName);
			savedVehicle = vehicleRepository.saveVehicle(vehicle);
		}
		else {
			savedVehicle = vehicleOptional.get();
		}
		ticket.setVehicle(savedVehicle);
		
		//assign a spot to the vehicle
		
		//Get ParkingLot from gate
		ParkingLot parkingLot = parkingLotRepository.getParkingLotByGate(gate);
		
		//Get spotAssignmentStrategyType from ParkingLot
		SpotAssignmentStrategyType spotAssignmentStrategyType= parkingLot.getSpotAssignmentStrategyType();
		//Get SpotAssignmentStrategy Object from factory by spotAssignmentStrategyType for the Parking Lot 
		SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSportAssignmentStrategyByType(spotAssignmentStrategyType);
		
		ticket.setAssignedSpot(spotAssignmentStrategy.getSpot(gate, vehicleType));
		
		Ticket savedTicket = ticketRepository.saveTicket(ticket);
		ticket.setNumber("Ticket-"+savedTicket.getId());
		//return ticket object
		return ticket;
	}

}
