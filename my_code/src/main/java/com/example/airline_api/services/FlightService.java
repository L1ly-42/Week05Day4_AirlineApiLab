package com.example.airline_api.services;

import com.example.airline_api.models.*;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlight(Long id) {
        return flightRepository.findById(id);
    }

    public void bookPassengerOntoFlight(PassengerIdDTO passengerIdDTO, Long flightId) {

        Flight targetFlight = flightRepository.findById(flightId).get();
        Passenger targetPassenger = passengerRepository.findById(passengerIdDTO.getPassengerId()).get();
        targetFlight.addPassenger(targetPassenger);
        flightRepository.save(targetFlight);
    }

    // you made this way more complicated than it needed to be! All you needed was to take a Flight object as input
    // and then to just return flightRepository.save(newFlight);
    //this is because usually when a new flight becomes available there will not already be people booked onto it!
    public Flight saveFlight(FlightDTO flightDTO) {
        Flight newFlight = new Flight(flightDTO.getDestination(), flightDTO.getCapacity(), flightDTO.getDepartureDate(), flightDTO.getDepartureTime());
        for (long passengerId : flightDTO.getPassengerIds()) {
            Passenger passenger = passengerRepository.findById(passengerId).get();
            newFlight.addPassenger(passenger);
        }
        return flightRepository.save(newFlight);

    }
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

}
