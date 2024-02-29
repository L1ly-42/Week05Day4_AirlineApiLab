package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationRunner args) throws Exception {

        //TAIWAN FLIGHT
        Flight taiwan = new Flight("Taipei", 200, "15/05/2021", "06:00");
        flightRepository.save(taiwan);

        Passenger kalina = new Passenger("Kalina", "k_sunny@gmail.com");
        kalina.addFlight(taiwan);
        passengerRepository.save(kalina);

        //JAPAN FLIGHT
        Flight japan = new Flight("Kyoto", 100, "15/01/2024", "01:00");
        flightRepository.save(japan);

        Passenger nina = new Passenger("Nina","n_dobrev@outlook.com");
        nina.addFlight(taiwan);
        nina.addFlight(japan);
        passengerRepository.save(nina);

        //SOUTH KOREA FLIGHT
        Flight southKorea = new Flight("Seoul", 800, "01/06/2022", "10:00");
        flightRepository.save(southKorea);

        Passenger ruadhan = new Passenger("Ruadhan","r_gilligan@yahoo.com");
        ruadhan.addFlight(southKorea);
        passengerRepository.save(ruadhan);

        //SPAIN FLIGHT
        Flight spain = new Flight("Sevilla", 2500, "22/07/2023", "05:30");
        flightRepository.save(spain);

        Passenger sharon = new Passenger("Sharon","s_stone@outlook.com");
        sharon.addFlight(spain);
        passengerRepository.save(sharon);

        Passenger leila = new Passenger("Leila","l_peltier@gmail.com");
        leila.addFlight(taiwan);
        leila.addFlight(southKorea);
        leila.addFlight(spain);
        passengerRepository.save(leila);


    }

}
