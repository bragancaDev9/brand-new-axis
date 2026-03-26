package com.example.brand_new_axis.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.brand_new_axis.entities.Ticket;
import com.example.brand_new_axis.entities.dtos.TicketResponseDTO;
import com.example.brand_new_axis.services.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	// Create
	
	// Read
	@GetMapping
	public ResponseEntity<List<TicketResponseDTO>> findAll() {
		List<Ticket> tickets = ticketService.findAll();
		
		List<TicketResponseDTO> listTicketDTO = tickets.stream()
				.map(TicketResponseDTO::new)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(listTicketDTO);
	}
	
	// Update
	
	// Delete
}
