package com.scaler.parkingLot.controllers;

import com.scaler.parkingLot.dtos.IssueTicketRequestDto;
import com.scaler.parkingLot.dtos.IssueTicketResponseDto;
import com.scaler.parkingLot.dtos.ResponseStatus;
import com.scaler.parkingLot.exceptions.GateNotFoundException;
import com.scaler.parkingLot.models.Ticket;
import com.scaler.parkingLot.services.TicketService;

public class TicketController {
	
	private TicketService ticketService;
	
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto) {
		
		IssueTicketResponseDto response = new IssueTicketResponseDto();
		Ticket ticket = null;
		try {
			 ticket = ticketService.issueTicket(requestDto.getVehicleType(),
					requestDto.getVehicleNumber(),
					requestDto.getVehicleOwnerName(),
					requestDto.getGateId());
		} catch (Exception e) {
			response.setResponseStatus(ResponseStatus.FAILURE);
			e.printStackTrace();
		}
		
		response.setTicket(ticket);
		response.setResponseStatus(ResponseStatus.SUCCESS);
		return response;
	}

}
