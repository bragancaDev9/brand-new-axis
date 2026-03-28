package com.example.brand_new_axis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.brand_new_axis.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	UserDetails findByLogin(String login);
}
