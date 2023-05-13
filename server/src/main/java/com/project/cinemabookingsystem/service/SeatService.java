package com.project.cinemabookingsystem.service;

import com.project.cinemabookingsystem.persistence.model.Seat;

public interface SeatService {
    Iterable<Seat> getSeats();

    Iterable<Seat> getSeatsPerHall(int hall);

    void updateSeats(Seat[] seats);
}
