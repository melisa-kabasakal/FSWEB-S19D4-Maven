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
@Table(name="movie", schema = "fsweb")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="director_name")
    private String directorName;

    @Column(name = "rating")
    private Integer rating;

    @Column(name="realise_date")
    private LocalDate releaseDate;

    @ManyToMany
    @JoinTable(
            name="movie_actor",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id")
    )
    private List<Actor> actors;

    public void addActor(Actor actor) {
        this.actors.add(actor);
        actor.getMovie().add(this);
    }

}
