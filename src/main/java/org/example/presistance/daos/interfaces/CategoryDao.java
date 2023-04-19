package org.example.presistance.daos.interfaces;

import org.example.presistance.entities.Category;
import org.example.presistance.entities.Film;

import java.util.List;

public interface CategoryDao {
    public List<Film> getFilmsInSpecificCategory(int id);

    public Category getCategoryOfHighestRentals();

    public List<Category> searchCategoryByName(String name);

    public long getNumberOfFilmsInSpecificCategory(int id);
}
