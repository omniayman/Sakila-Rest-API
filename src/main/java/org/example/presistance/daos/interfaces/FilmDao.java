package org.example.presistance.daos.interfaces;

import org.example.presistance.entities.*;
import org.example.presistance.enums.Rate;

import java.util.List;

public interface FilmDao {
    public List<Actor> getFilmActors(int id);

    public List<Category> getFilmCategory(int id);

    public Language getFilmLanguage(int id);

    public Boolean CheckFilmInventory(int id);

    public Long getNumberOfFilmsInInventory(int id);

    public List<Store> getFilmStores(int id);

    public Enum<Rate> getFilmRate(int id);

    public List<Rental> getFilmRentals(int id);
}
