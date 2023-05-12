package com.project.cinemabookingsystem.service;

import com.project.cinemabookingsystem.persistence.model.Movie;
import com.project.cinemabookingsystem.persistence.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repo;

    @Override
    public Iterable<Movie> getMovies() {
        return repo.findAll();
    }

    @Override
    public Movie getMovie(Long id) {
        return null;
    }
}
