package com.railway.service;

import com.railway.dao.PassengerDao;
import com.railway.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerDao passengerDao;

    @Override
    public void savePassenger(Passenger passenger) {
        passengerDao.save(passenger);
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        passengerDao.update(passenger);
    }

    @Override
    public void deletePassenger(int id) {
        passengerDao.delete(id);
    }

    @Override
    public Passenger getPassengerById(int id) {
        return passengerDao.getById(id);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerDao.getAll();
    }
    
}