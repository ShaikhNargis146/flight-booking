package com.luv2code.springboot.flightList.dao;

import com.luv2code.springboot.flightList.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	
	Optional<Passenger> findByEmail(String email);
	
}
