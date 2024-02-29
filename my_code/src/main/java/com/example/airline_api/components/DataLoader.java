package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Passengers
        Passenger leila = new Passenger("Leila", "l_peltier@gmail.com");
        passengerRepository.save(leila);

        Passenger sharon = new Passenger("Sharon", "s_stone@yahoo.com");
        passengerRepository.save(sharon);

        Passenger nina = new Passenger("Nina", "n_dobrev@outlook.com");
        passengerRepository.save(nina);

        Passenger yabbi = new Passenger("Yabbi", "y_dhali@gmail.com");
        passengerRepository.save(yabbi);

        Passenger kajanan = new Passenger("Kajanan", "k_link@gmail.com");
        passengerRepository.save(kajanan);



        //TAIWAN FLIGHT
        Flight taiwan = new Flight("Taipei",300,"15/05/2021","06:00");
        taiwan.addPassenger(leila);
        taiwan.addPassenger(nina);
        taiwan.addPassenger(kajanan);
        flightRepository.save(taiwan);

        //KOREA FLIGHT
        Flight southKorea = new Flight("Seoul",1100,"10/06/2022","10:00");
        southKorea.addPassenger(yabbi);
        southKorea.addPassenger(leila);
        flightRepository.save(southKorea);

        //JAPAN FLIGHT
        Flight japan = new Flight("Kyoto",20,"06/01/2024","01:00");
        japan.addPassenger(nina);
        flightRepository.save(japan);

        //SPAIN FLIGHT
        Flight spain = new Flight("Seville",1900,"22/07/2023","04:00");
        taiwan.addPassenger(leila);
        taiwan.addPassenger(sharon);
        taiwan.addPassenger(kajanan);
        flightRepository.save(spain);

    }
    }