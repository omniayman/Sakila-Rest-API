package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.daos.interfaces.FilmDao;
import org.example.presistance.entities.*;
import org.example.presistance.enums.Rate;

import java.util.List;

public class FilmDaoImpl extends Crud<Film, Integer> implements FilmDao {
    EntityManager entityManager;

    public FilmDaoImpl() {
        entityManager = super.getEntityManager();
    }

    @Override
    public List<Actor> getFilmActors(int id) {

        return (List<Actor>) entityManager.createQuery(" from Actor a where a.film.id=?1").setParameter(1, id).getResultList();
    }

    @Override
    public List<Category> getFilmCategory(int id) {

        return (List<Category>) entityManager.createQuery(" from Actor a where a.category.id=?1").setParameter(1, id).getResultList();
    }

    @Override
    public Language getFilmLanguage(int id) {
        return (Language) entityManager.createQuery(" from Actor a where a.language.id=?1").setParameter(1, id).getSingleResult();


    }

    @Override
    public Boolean CheckFilmInventory(int id) {
        Long count = (Long) entityManager.createQuery("select count(*) from Inventory i where i.film.id=?1").
                setParameter(1, id).getSingleResult();
        return count != 0;
    }

    @Override
    public Long getNumberOfFilmsInInventory(int id) {
        Long count = (Long) entityManager.createQuery("select count(*) from Inventory i where i.film.id=?1").
                setParameter(1, id).getSingleResult();
        return count;
    }

    @Override
    public List<Store> getFilmStores(int id) {
        String query = "select s from Store s  join Inventory i  where i.film.id=?1";
        List<Store> stores = (List<Store>) entityManager.createQuery(query).
                setParameter(1, id).getResultList();
        return stores;
    }

    @Override
    public Rate getFilmRate(int id) {

        Rate rate = (Rate) entityManager.createQuery("select i.rating from Film i where i.id=?1").
                setParameter(1, id).getSingleResult();
        return rate;
    }

    @Override
    public List<Rental> getFilmRentals(int id) {
        String query = "select r from Rental r  join Inventory i  where i.film.id=?1";
        List<Rental> rentals = (List<Rental>) entityManager.createQuery(query).
                setParameter(1, id).getResultList();
        return rentals;
    }


    @Override
    public void add(Film film) {

        Language language = entityManager.find(Language.class, film.getLanguage().getId());
        film.setLanguage(language);

        if (film.getOriginalLanguage().getId() != null) {

            Language orginalLanguage = entityManager.find(Language.class, film.getOriginalLanguage().getId());
            film.setOriginalLanguage(orginalLanguage);
        } else
            film.setOriginalLanguage(null);
        entityManager.getTransaction().begin();
        entityManager.persist(film);
        entityManager.getTransaction().commit();

    }

    @Override
    public void update(Film editedFilm) {
        Film film = entityManager.find(Film.class, editedFilm.getId());
        Language language = entityManager.find(Language.class, editedFilm.getLanguage().getId());
        editedFilm.setLanguage(language);

        if (editedFilm.getOriginalLanguage().getId() != null) {

            Language orginalLanguage = entityManager.find(Language.class, editedFilm.getOriginalLanguage().getId());
            editedFilm.setOriginalLanguage(orginalLanguage);
        } else
            editedFilm.setOriginalLanguage(null);
        entityManager.getTransaction().begin();
        entityManager.merge(editedFilm);
        entityManager.getTransaction().commit();

    }

}
