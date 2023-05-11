package com.project.cinemabookingsystem.persistence;

import com.project.cinemabookingsystem.persistence.model.Movie;
import com.project.cinemabookingsystem.persistence.repository.MovieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SeedDB {
    public MovieRepository repo;

    public SeedDB(MovieRepository repo) {
        this.repo = repo;
    }

    @PostConstruct
    public void init(){
        repo.save(new Movie("Minions", "Minions is a movie for kids", LocalDateTime.of(2019, 3, 28, 14, 33, 48, 000000), "cartoon", 10, "/src/assets/film1.jpg", 1, 30));
        repo.save(new Movie("The Matrix", "The Matrix is a computer-generated dream world designed to keep these humans under control.", LocalDateTime.of(2019, 10, 28, 14, 33, 48, 000000), "cartoon", 50, "/src/assets/film2.png", 2, 25));
    }
}
