package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.dao.PassengerRepo;
import com.org.model.Passenger1;

@Component
public class PassengerServiceImpl {
    @Autowired
    PassengerRepo passengerRepo;


    public Passenger1 addPassenger(Passenger1 passenger){
        return passengerRepo.save(passenger);
    }

    public Passenger1 getPassengerById(int passengerId){
        return passengerRepo.findByPassengerId(passengerId);
    }

    public List<Passenger1> getAllPassenger(){
        return passengerRepo.findAll();
    }

    public void deleteByPassengerId(int passengerId){
        passengerRepo.deleteByPassengerId(passengerId);
    }


}