package com.project.cinemabookingsystem.controller;

import com.project.cinemabookingsystem.persistence.model.Seat;
import com.project.cinemabookingsystem.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seats")
@CrossOrigin
public class SeatController {
    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Seat>> getSeats(){
        return ResponseEntity.ok().body(seatService.getSeats());
    }

    @GetMapping("hall")
    public ResponseEntity<Iterable<Seat>> getSeatsPerHall(int hall){
        return ResponseEntity.ok().body(seatService.getSeatsPerHall(hall));
    }

    @PutMapping()
    public ResponseEntity<Iterable<Seat>> updateSeats(@RequestBody Seat[] seats){
        seatService.updateSeats(seats);
        return ResponseEntity.ok().build();
    }
}
