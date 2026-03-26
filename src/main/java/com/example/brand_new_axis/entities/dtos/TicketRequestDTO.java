package com.example.brand_new_axis.entities.dtos;

import com.example.brand_new_axis.entities.Ticket;

public class TicketRequestDTO {
	private String title;
	private String description;
	
	public TicketRequestDTO() {}

	public TicketRequestDTO(Ticket ticket) {
		title = ticket.getTitle();
		description = ticket.getDescription();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
