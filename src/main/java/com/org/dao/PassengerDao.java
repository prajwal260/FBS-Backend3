package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Passenger1;

@Repository
public interface PassengerDao extends JpaRepository<Passenger1,String>{

}