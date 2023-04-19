package org.example.services;

import org.example.Mappers.RentalMapper;
import org.example.Mappers.StoreMapper;
import org.example.Mappers.film.FilmMapper;
import org.example.dtos.RentalDto;
import org.example.dtos.StoreDto;
import org.example.dtos.film.FilmDto;
import org.example.presistance.daos.impl.FilmDaoImpl;
import org.example.presistance.entities.*;
import org.example.presistance.enums.Rate;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmService {
    private FilmMapper mapper;
    private FilmDaoImpl filmDao;

    public FilmService() {
        filmDao = new FilmDaoImpl();
        mapper = Mappers.getMapper(FilmMapper.class);
    }

    public List<FilmDto> getAllFilms() {
        List<Film> films = filmDao.findAll();
        List<FilmDto> filmDtos = new ArrayList<>();
        for (Film film : films) {
            filmDtos.add(mapper.toDto(film));
        }
        return filmDtos;
    }

    public FilmDto getFilmById(int id) {
        Film film = filmDao.findById(id, Film.class);
        return mapper.toDto(film);
    }

    public List<Actor> getFilmActors(int id) {
        return null;
    }


    public List<Category> getFilmCategory(int id) {
        return null;
    }


    public Language getFilmLanguage(int id) {
        return null;
    }


    public Boolean CheckFilmInventory(int id) {
        return filmDao.CheckFilmInventory(id);

    }


    public Long getNumberOfFilmsInInventory(int id) {

        return filmDao.getNumberOfFilmsInInventory(id);
    }


    public List<StoreDto> getFilmStores(int id) {

        StoreMapper storeMapper = Mappers.getMapper(StoreMapper.class);
        List<Store> stores = filmDao.getFilmStores(id);
        List<StoreDto> storeDto = new ArrayList<>();
        for (Store s : stores
        ) {
            storeDto.add(storeMapper.toDto(s));
        }
        return storeDto;
    }


    public Rate getFilmRate(int id) {
        return filmDao.getFilmRate(id);
    }


    public List<RentalDto> getFilmRentals(int id) {
        RentalMapper rentalMapper = Mappers.getMapper(RentalMapper.class);
        List<Rental> rentals = filmDao.getFilmRentals(id);
        List<RentalDto> rentalDtos = new ArrayList<>();
        for (Rental s : rentals
        ) {
            rentalDtos.add(rentalMapper.toDto(s));
        }
        return rentalDtos;
    }

    public void add(FilmDto filmDto) {
        FilmMapper mapper = Mappers.getMapper(FilmMapper.class);
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        filmDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Film film = mapper.toEntity(filmDto);
        filmDao.add(film);
    }

    public void update(FilmDto filmDto) {

        FilmMapper mapper = Mappers.getMapper(FilmMapper.class);
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        filmDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Film film = mapper.toEntity(filmDto);
        filmDao.update(film);
    }
}
