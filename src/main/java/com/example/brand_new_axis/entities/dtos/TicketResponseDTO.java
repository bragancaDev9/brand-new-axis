package com.example.brand_new_axis.entities.dtos;

import java.util.Date;

import com.example.brand_new_axis.entities.Ticket;

public class TicketResponseDTO {
	private String title;
	private String description;
	private Date date;
	
	public TicketResponseDTO(Ticket ticket) {
		title = ticket.getTitle();
		description = ticket.getDescription();
		date = ticket.getDate();
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
