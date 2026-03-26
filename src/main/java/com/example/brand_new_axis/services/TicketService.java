package com.example.brand_new_axis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.brand_new_axis.entities.Ticket;
import com.example.brand_new_axis.repositories.TicketRepository;
import com.example.brand_new_axis.services.exceptions.ObjectNotFoundException;

@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	
	// Create
	public void insert(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	// Read
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}
	
	public Ticket findById(Long id) {
		return ticketRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id));
	}
	
	// Update
	public Ticket update(Ticket ticket) {
		Ticket newTicket = ticketRepository.findById(ticket.getId()).orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + ticket.getId()));
		
		updateData(newTicket, ticket);
		
		return ticketRepository.save(newTicket);
	}
	
	private void updateData(Ticket newTicket, Ticket ticket) {
		newTicket.setTitle(ticket.getTitle());
		newTicket.setDescription(ticket.getDescription());
	}
	
	// Delete
}
