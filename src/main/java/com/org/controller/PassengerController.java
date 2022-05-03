package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Passenger1;
import com.org.service.PassengerServiceImpl;


@RestController
@RequestMapping("/api")
public class PassengerController {

    @Autowired
    PassengerServiceImpl passengerService;

    @PostMapping("/addpassenger")
    public Passenger1 addPassenger(@RequestBody Passenger1 passenger){
        return passengerService.addPassenger(passenger);
    }

    @GetMapping("/passenger/{passengerId}")
    public Passenger1 getPassengerById(@PathVariable int passengerId){
        return passengerService.getPassengerById(passengerId);
    }

    @GetMapping("/passengers")
    public List<Passenger1> getAllPassengers(){

        return passengerService.getAllPassenger();
    }

    @DeleteMapping("/deletepassenger/{passengerId}")
    public String deleteByPassengerId(@PathVariable int passengerId){
        passengerService.deleteByPassengerId(passengerId);
        return "Data Deleted Successfully";
    }


}
