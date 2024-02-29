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
    }

    public Flight saveFlight(FlightDTO flightDTO) {
        Flight newFlight = new Flight(flightDTO.getDestination(), flightDTO.getCapacity(), flightDTO.getDepartureDate(), flightDTO.getDepartureTime());
        for (long passengerId : flightDTO.getPassengerIds()) {
            Passenger passenger = passengerRepository.findById(passengerId).get();
            newFlight.addPassenger(passenger);
        }
        return flightRepository.save(newFlight);

    }

}
