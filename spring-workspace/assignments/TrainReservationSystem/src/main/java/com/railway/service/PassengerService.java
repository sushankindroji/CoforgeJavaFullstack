package com.railway.service;

import com.railway.entity.Passenger;
import java.util.List;

public interface PassengerService {
    void savePassenger(Passenger passenger);
    void updatePassenger(Passenger passenger);
    void deletePassenger(int id);
    Passenger getPassengerById(int id);
    List<Passenger> getAllPassengers();
}