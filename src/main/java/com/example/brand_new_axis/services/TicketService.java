package com.example.brand_new_axis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.brand_new_axis.entities.Ticket;
import com.example.brand_new_axis.repositories.TicketRepository;

@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	
	// Create
	
	// Read
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}
	
	// Update
	
	// Delete
}
