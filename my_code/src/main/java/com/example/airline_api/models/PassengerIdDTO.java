package com.example.airline_api.models;

public class PassengerIdDTO {

    private long passengerId;

    public PassengerIdDTO(){}

    public PassengerIdDTO(long passengerId){
        this.passengerId = passengerId;
    }

    public long getPassengerId() {
        return this.passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }
}
