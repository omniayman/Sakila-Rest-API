package org.example.presentation.controllers;


import org.example.dtos.RentalDto;
import org.example.dtos.StoreDto;
import org.example.dtos.film.FilmDto;
import org.example.presistance.entities.Actor;
import org.example.presistance.entities.Category;
import org.example.presistance.entities.Language;
import org.example.presistance.enums.Rate;
import org.example.services.FilmService;

import java.util.List;


public class Film {
    FilmService filmService = new FilmService();

    public List<FilmDto> getAll() {
        FilmService filmService = new FilmService();
        List<FilmDto> filmDtos = filmService.getAllFilms();

        return filmDtos;
    }

    public FilmDto getFilmById(int id) {
        FilmService filmService = new FilmService();

        return filmService.getFilmById(id);
    }

    public void addFilm(FilmDto film) {
        FilmService filmService = new FilmService();
        filmService.add(film);
    }

    public void updateFilm(FilmDto film) {
        FilmService filmService = new FilmService();
        filmService.update(film);
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
        return filmService.CheckFilmInventory(id);
    }


    public long getNumberOfFilmsInInventory(int id) {
        return filmService.getNumberOfFilmsInInventory(id);
    }


    public List<StoreDto> getFilmStores(int id) {
        return filmService.getFilmStores(id);
    }


    public Rate getFilmRate(int id) {
        return filmService.getFilmRate(id);
    }


    public List<RentalDto> getFilmRentals(int id) {
        return filmService.getFilmRentals(id);
    }
}
