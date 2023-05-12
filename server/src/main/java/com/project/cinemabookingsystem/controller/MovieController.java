package com.project.cinemabookingsystem.controller;

import com.project.cinemabookingsystem.persistence.model.Movie;
import com.project.cinemabookingsystem.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@CrossOrigin
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>> getMovies(){
        return ResponseEntity.ok().body(movieService.getMovies());
    }
}
