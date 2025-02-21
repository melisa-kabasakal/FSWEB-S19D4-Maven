package com.workintech.s19d1.service;

import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.MovieRepository;
import com.workintech.s19d1.entity.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service

public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ApiException("Movie not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public Movie delete(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ApiException("Movie not found for deletion", HttpStatus.NOT_FOUND));

        movieRepository.deleteById(id);
        return movie;
    }
}
