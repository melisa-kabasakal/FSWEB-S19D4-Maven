package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @NotNull
    private String name;

    @Column(name="director_name")
    @NotNull
    private String directorName;

    @Column(name = "rating")
    private Integer rating;

    @Column(name="realise_date")
    private LocalDate releaseDate;

    @ManyToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_actor", schema = "fsweb",
            inverseJoinColumns = @JoinColumn(name = "actor_id"),
            joinColumns = @JoinColumn(name = "movie_id"))
    private List<Actor> actors;

    public void addActor(Actor actor) {
       if(actors == null){
           actors = new ArrayList<>();
       }
       actors.add(actor);
    }

}
