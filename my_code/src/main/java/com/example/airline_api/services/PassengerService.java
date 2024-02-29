package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassenger(Long id){
        return passengerRepository.findById(id).get();
    }

    public Passenger savePassenger(PassengerDTO passengerDTO){
        Passenger newPassenger = new Passenger(passengerDTO.getName(),passengerDTO.getEmail());
        for(long flightId: passengerDTO.getFlightIds()){
            Flight flight = flightRepository.findById(flightId).get();
            newPassenger.addFlight(flight);
        }
        return passengerRepository.save(newPassenger);
    }

    }

