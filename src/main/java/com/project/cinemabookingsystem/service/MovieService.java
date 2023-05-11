package com.project.cinemabookingsystem.service;

import com.project.cinemabookingsystem.persistence.model.Movie;

public interface MovieService {
    Iterable<Movie> getMovies();
    Movie getMovie(Long id);
}
