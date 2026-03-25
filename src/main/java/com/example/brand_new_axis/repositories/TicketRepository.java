package com.example.brand_new_axis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.brand_new_axis.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
