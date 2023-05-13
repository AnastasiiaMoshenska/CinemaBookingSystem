package com.project.cinemabookingsystem.persistence.repository;

import com.project.cinemabookingsystem.persistence.model.Seat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Long> {
    @Query("select e from Seat e where e.hall = ?1")
    Iterable<Seat> getSeatsPerHall(int hall);
}
