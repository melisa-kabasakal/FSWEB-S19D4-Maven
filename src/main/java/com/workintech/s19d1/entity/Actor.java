package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="actor", schema = "fsweb")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @ManyToMany(mappedBy = "actor")
    private List<Movie> movie;

    public void setMovies(List<Movie> movie) {
        this.movie = movie;
    }

    public List<Movie> getMovies() {
        return movie;
    }

    public void addMovie(Movie movie) {
        this.movie.add(movie);
        movie.getActors().add(this);
    }


}
