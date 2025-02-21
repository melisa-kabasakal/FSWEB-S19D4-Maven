package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;

import java.util.List;

public interface ActorService {
    Actor save(Actor actor);
    Actor findById(Long id);
    List<Actor> findAll();
    Actor update(Actor actor);
    Actor delete (Long id);
}
