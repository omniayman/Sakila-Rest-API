package org.example.presistance.daos.interfaces;

import org.example.presistance.entities.Actor;
import org.example.presistance.entities.Film;

import java.util.List;

public interface ActorDao {
    public List<Film> getFilmsByActorId(int id);

    public List<Actor> getActorByName(String name);

}
