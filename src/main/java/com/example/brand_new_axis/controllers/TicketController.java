package com.example.brand_new_axis.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.brand_new_axis.entities.Ticket;
import com.example.brand_new_axis.entities.dtos.TicketRequestDTO;
import com.example.brand_new_axis.entities.dtos.TicketResponseDTO;
import com.example.brand_new_axis.services.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	// Create
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TicketRequestDTO ticketDTO) {
		Ticket ticket = new Ticket(null, ticketDTO.getTitle(), ticketDTO.getDescription());
		
		ticketService.insert(ticket);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(ticket.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// Read
	@GetMapping
	public ResponseEntity<List<TicketResponseDTO>> findAll() {
		List<Ticket> tickets = ticketService.findAll();
		
		List<TicketResponseDTO> listTicketDTO = tickets.stream()
				.map(TicketResponseDTO::new)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(listTicketDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TicketResponseDTO> findById(@PathVariable Long id) {
		Ticket ticket = ticketService.findById(id);
		
		TicketResponseDTO ticketDTO = new TicketResponseDTO(ticket);
		
		return ResponseEntity.ok(ticketDTO);
	}
	
	// Update
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TicketRequestDTO ticketDTO) { 
		Ticket ticket = new Ticket();
		ticket.setId(id);
		ticket.setTitle(ticketDTO.getTitle());
		ticket.setDescription(ticketDTO.getDescription());
		ticket = ticketService.update(ticket);
		
		return ResponseEntity.noContent().build();
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ticketService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
