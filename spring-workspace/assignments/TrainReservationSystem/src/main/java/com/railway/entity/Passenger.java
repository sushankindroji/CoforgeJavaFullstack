package com.railway.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private int passengerId;

    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "aadhaar_number", nullable = false)
    private String aadhaarNumber;

    @Column(name = "source_station", nullable = false)
    private String sourceStation;

    @Column(name = "destination_station", nullable = false)
    private String destinationStation;

    @Temporal(TemporalType.DATE)
    @Column(name = "journey_date", nullable = false)
    private Date journeyDate;

    @Column(name = "seat_class", nullable = false)
    private String seatClass;

    @Column(name = "ticket_fare", nullable = false)
    private double ticketFare;

    // Getters and Setters
    public int getPassengerId() { return passengerId; }
    public void setPassengerId(int passengerId) { this.passengerId = passengerId; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAadhaarNumber() { return aadhaarNumber; }
    public void setAadhaarNumber(String aadhaarNumber) { this.aadhaarNumber = aadhaarNumber; }

    public String getSourceStation() { return sourceStation; }
    public void setSourceStation(String sourceStation) { this.sourceStation = sourceStation; }

    public String getDestinationStation() { return destinationStation; }
    public void setDestinationStation(String destinationStation) { this.destinationStation = destinationStation; }

    public Date getJourneyDate() { return journeyDate; }
    public void setJourneyDate(Date journeyDate) { this.journeyDate = journeyDate; }

    public String getSeatClass() { return seatClass; }
    public void setSeatClass(String seatClass) { this.seatClass = seatClass; }

    public double getTicketFare() { return ticketFare; }
    public void setTicketFare(double ticketFare) { this.ticketFare = ticketFare; }
}