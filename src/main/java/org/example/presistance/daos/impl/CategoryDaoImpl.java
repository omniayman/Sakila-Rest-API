package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.daos.interfaces.CategoryDao;
import org.example.presistance.entities.Category;
import org.example.presistance.entities.Film;

import java.util.List;

public class CategoryDaoImpl extends Crud<Category, Integer> implements CategoryDao {
    EntityManager entityManager;

    public CategoryDaoImpl() {
        entityManager = super.getEntityManager();
    }

    @Override
    public List<Film> getFilmsInSpecificCategory(int id) {
        return (List<Film>) entityManager.createQuery("select f from Film f join FilmCategory fa where fa.id.categoryId = ?1").
                setParameter(1, id).getResultList();
    }

    @Override
    public Category getCategoryOfHighestRentals() {
        return null;
    }

    @Override
    public List<Category> searchCategoryByName(String name) {
        return (List<Category>) entityManager.createQuery("from Category a where a.name like ?1").
                setParameter(1, "%" + name + "%").getResultList();
    }

    @Override
    public long getNumberOfFilmsInSpecificCategory(int id) {
        return (Long) entityManager.createQuery("select count(*) from  FilmCategory fa where fa.id.categoryId = ?1").
                setParameter(1, id).getSingleResult();
    }
}
