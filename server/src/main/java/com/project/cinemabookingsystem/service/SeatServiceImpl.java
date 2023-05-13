package com.project.cinemabookingsystem.service;

import com.project.cinemabookingsystem.persistence.model.Seat;
import com.project.cinemabookingsystem.persistence.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {
    private final String booked = "booked";
    @Autowired
    private SeatRepository repo;
    @Override
    public Iterable<Seat> getSeats() {
        return repo.findAll();
    }

    @Override
    public Iterable<Seat> getSeatsPerHall(int hall) {
        return repo.getSeatsPerHall(hall);
    }

    @Override
    public void updateSeats(Seat[] seats) {
        for(Seat seat : seats){
            Seat current = repo.findById((long) seat.getId()).orElseThrow(RuntimeException::new);
            current.setStatus(booked);
            current = repo.save(current);
        }
    }
}
