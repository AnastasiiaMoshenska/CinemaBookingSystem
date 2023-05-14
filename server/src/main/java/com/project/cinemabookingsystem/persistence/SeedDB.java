package com.project.cinemabookingsystem.persistence;

import com.project.cinemabookingsystem.persistence.model.Movie;
import com.project.cinemabookingsystem.persistence.model.Seat;
import com.project.cinemabookingsystem.persistence.repository.MovieRepository;
import com.project.cinemabookingsystem.persistence.repository.SeatRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SeedDB {
    public MovieRepository movieRepository;
    public SeatRepository seatRepository;
    private final int numberOfHalls = 2;
    private final int numberOfSeatsInRow = 7;
    private final int numberOfSeats = 28;
    private final String status = "free";

    public SeedDB(MovieRepository movieRepository, SeatRepository seatRepository) {
        this.movieRepository = movieRepository;
        this.seatRepository = seatRepository;
    }

    @PostConstruct
    public void init(){
        movieRepository.save(new Movie("Minions", " American computer-animated comedy film produced by Illumination Entertainment", LocalDateTime.of(2019, 3, 28, 14, 33, 48, 0), "cartoon", 10, "/src/assets/film1.jpg", 1, 30));
        movieRepository.save(new Movie("The Matrix", "The Matrix is a computer-generated dream world designed to keep these humans under control.", LocalDateTime.of(2019, 10, 28, 14, 33, 48, 0), "cartoon", 50, "/src/assets/film2.png", 2, 25));

        for(int hall = 1; hall <= numberOfHalls; hall++){
            int row = 1;
            for(int seat = 1; seat <= numberOfSeats; seat++){
                seatRepository.save(new Seat(row, seat, hall, status));
                if(seat % numberOfSeatsInRow == 0){
                    row++;
                }
            }
        }

    }
}
