package com.org.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Passenger1;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger1, Integer> {

    public Passenger1 findByPassengerId(int passengerId);

    List<Passenger1> deleteByPassengerId (int passengerId);

}
