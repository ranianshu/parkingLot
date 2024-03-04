package com.scaler.parkingLot.repositories;

import com.scaler.parkingLot.models.Ticket;
import java.util.Map;
import java.util.HashMap;

public class TicketRepository {
	
	private Map<Long, Ticket> tickets = new HashMap<>();
	
	private Long previousId = 0L;
	
	public Ticket saveTicket(Ticket ticket) {
		previousId += 1;
		ticket.setId(previousId);
		tickets.put(previousId, ticket);
		return ticket;
	}

}
