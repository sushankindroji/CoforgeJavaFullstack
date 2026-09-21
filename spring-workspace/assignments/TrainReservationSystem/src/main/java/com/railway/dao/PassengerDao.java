package com.railway.dao;

import com.railway.entity.Passenger;
import java.util.List;

public interface PassengerDao {
    void save(Passenger passenger);
    void update(Passenger passenger);
    void delete(int id);
    Passenger getById(int id);
    List<Passenger> getAll();
}