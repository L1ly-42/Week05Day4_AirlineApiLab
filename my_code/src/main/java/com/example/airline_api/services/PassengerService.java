package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // savePassenger() didn't work properly because you need to save the passenger to the database BEFORE adding them to flights!
    // The steps therefore would be like this instead:

    // 1 = passenger object from DTO
    // 2 = save passenger to db
    // 3 = find flights by id
    // 4 = add passenger to flight
    // 5 = save flight

    // Doing it in this order ensures that the passenger will have an id with which the flights can be attached to.
    // The order you did prevents the flights from connecting from anything therefore you will just have created a passenger
    // with no flights!

    //Although in the solution the passenger was added without any flights for the same reason as the flights were not given
    // preexisting passengers so again the input could have just been a Passenger object!
    public Passenger savePassenger(PassengerDTO passengerDTO){
        Passenger newPassenger = new Passenger(passengerDTO.getName(),passengerDTO.getEmail());
        for(long flightId: passengerDTO.getFlightIds()){
            Flight flight = flightRepository.findById(flightId).get();
            newPassenger.addFlight(flight);
        }
        return passengerRepository.save(newPassenger);
    }

    }

