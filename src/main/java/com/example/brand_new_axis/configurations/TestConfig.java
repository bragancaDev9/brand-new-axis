package com.example.brand_new_axis.configurations;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.brand_new_axis.entities.Ticket;
import com.example.brand_new_axis.repositories.TicketRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Ticket t1 = new Ticket(null, "Title", "Description", new Date());
		Ticket t2 = new Ticket(null, "Title-1", "Description-2", new Date());

		ticketRepository.saveAll(Arrays.asList(t1, t2));
	}
}
