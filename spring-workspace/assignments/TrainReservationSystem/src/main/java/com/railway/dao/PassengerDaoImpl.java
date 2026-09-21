package com.railway.dao;

import com.railway.entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerDaoImpl implements PassengerDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Passenger passenger) {
        getSession().persist(passenger);
    }

    @Override
    public void update(Passenger passenger) {
        getSession().merge(passenger);
    }

    @Override
    public void delete(int id) {
        Passenger p = getById(id);
        if (p != null) {
            getSession().remove(p);
        }
    }

    @Override
    public Passenger getById(int id) {
        return getSession().find(Passenger.class, id);
    }

    @Override
    public List<Passenger> getAll() {
        return getSession()
                .createQuery("FROM Passenger", Passenger.class)
                .getResultList();
    }
}