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
        movieRepository.save(new Movie("Minions", "American computer-animated comedy film produced by Illumination Entertainment", LocalDateTime.of(2023, 9, 28, 14, 30, 0, 0), "Cartoon", 0, "/src/assets/movie1.jpg", 1, 20));
        movieRepository.save(new Movie("The Matrix", "The Matrix is a computer-generated dream world designed to keep these humans under control.", LocalDateTime.of(2023, 10, 3, 20, 0, 0, 0), "Action", 18, "/src/assets/movie2.jpg", 2, 30));

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
