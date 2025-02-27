package com.workintech.s19d1.dto;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;

import java.time.LocalDate;
import java.util.List;

public record ActorResponse(Long id, String firstName, String lastName, LocalDate birtDate, List<Movie> movies) {
}
