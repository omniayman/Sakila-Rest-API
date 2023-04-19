package org.example.services;

import org.example.Mappers.actor.ActorMapper;
import org.example.Mappers.film.FilmMapper;
import org.example.dtos.actor.ActorDto;
import org.example.dtos.film.FilmDto;
import org.example.presistance.daos.impl.ActorDaoImpl;
import org.example.presistance.entities.Actor;
import org.example.presistance.entities.Film;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ActorService {
    private ActorMapper mapper;
    private ActorDaoImpl actorDao;

    public ActorService() {
        actorDao = new ActorDaoImpl();
        mapper = Mappers.getMapper(ActorMapper.class);
    }

    public List<ActorDto> getAllActors() {
        List<Actor> actors = actorDao.findAll();
        List<ActorDto> actorDtos = new ArrayList<>();
        for (Actor actor : actors) {
            actorDtos.add(mapper.toDto(actor));
        }
        return actorDtos;
    }

    public ActorDto getActorById(int id) {
        Actor actor = actorDao.findById(id, Actor.class);
        return mapper.toDto(actor);
    }

    public void updateActor(ActorDto actorDto) {

        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        actorDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Actor actor = mapper.toEntity(actorDto);
        actorDao.update(actor);
    }

    public void addActor(ActorDto actorDto) throws InvalidDataException {
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        actorDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());

        Actor actor = mapper.toEntity(actorDto);
        actorDao.add(actor);
    }

    public List<FilmDto> getFilmsByActorId(int id) {
        FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);
        List<Film> films = actorDao.getFilmsByActorId(id);
        List<FilmDto> filmDtos = new ArrayList<>();
        for (Film film : films) {
            filmDtos.add(filmMapper.toDto(film));
        }
        return filmDtos;

    }

    public List<ActorDto> getActorsByName(String name) {
        List<Actor> actors = actorDao.getActorByName(name);
        List<ActorDto> actorDtos = new ArrayList<>();
        for (Actor actor : actors) {
            actorDtos.add(mapper.toDto(actor));
        }
        return actorDtos;
    }

}
