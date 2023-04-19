package org.example.presentation.controllers;


import org.example.dtos.category.CategoryDto;
import org.example.dtos.film.FilmDto;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.example.services.CategoryService;

import java.util.List;


public class Category {
    CategoryService categoryService = new CategoryService();

    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    public CategoryDto getCategoryById(int id) {
        return categoryService.getCategoryById(id);
    }

    public void updateCategory(CategoryDto categoryDto) {

        categoryService.updateCategory(categoryDto);
    }

    public void addCategory(CategoryDto categoryDto) throws InvalidDataException {
        categoryService.addCategory(categoryDto);
    }

    public List<FilmDto> getFilmsByCategoryId(int id) {

        return categoryService.getFilmsByCategoryId(id);

    }

    public List<CategoryDto> getCategoryByName(String name) {

        return categoryService.getCategoriesByName(name);
    }

    public long getFilmsCountInCategory(int id) {
        return categoryService.getFilmsInCategory(id);
    }
}
