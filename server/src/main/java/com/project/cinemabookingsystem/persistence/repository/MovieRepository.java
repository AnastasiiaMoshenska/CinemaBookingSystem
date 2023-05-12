package com.project.cinemabookingsystem.persistence.repository;

import com.project.cinemabookingsystem.persistence.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
