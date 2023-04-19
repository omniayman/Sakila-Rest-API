package org.example.services;

import org.example.Mappers.category.CategoryMapper;
import org.example.Mappers.film.FilmMapper;
import org.example.dtos.category.CategoryDto;
import org.example.dtos.film.FilmDto;
import org.example.presistance.daos.impl.CategoryDaoImpl;
import org.example.presistance.entities.Category;
import org.example.presistance.entities.Film;
import org.example.presistance.exceptionHandler.InvalidDataException;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryService {
    private CategoryMapper mapper;
    private CategoryDaoImpl categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDaoImpl();
        mapper = Mappers.getMapper(CategoryMapper.class);
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryDao.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
            categoryDtos.add(mapper.toDto(category));
        }
        return categoryDtos;
    }

    public CategoryDto getCategoryById(int id) {
        Category category = categoryDao.findById(id, Category.class);
        return mapper.toDto(category);
    }

    public void updateCategory(CategoryDto categoryDto) {

        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        categoryDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());
        Category category = mapper.toEntity(categoryDto);
        categoryDao.update(category);
    }

    public void addCategory(CategoryDto categoryDto) throws InvalidDataException {
        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        categoryDto.setLastUpdate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()).toInstant());

        Category category = mapper.toEntity(categoryDto);
        categoryDao.add(category);
    }

    public List<FilmDto> getFilmsByCategoryId(int id) {
        FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);
        List<Film> films = categoryDao.getFilmsInSpecificCategory(id);
        List<FilmDto> filmDtos = new ArrayList<>();
        for (Film film : films) {
            filmDtos.add(filmMapper.toDto(film));
        }
        return filmDtos;

    }

    public List<CategoryDto> getCategoriesByName(String name) {
        List<Category> categories = categoryDao.searchCategoryByName(name);
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
            categoryDtos.add(mapper.toDto(category));
        }
        return categoryDtos;
    }

    public long getFilmsInCategory(int id) {
        return categoryDao.getNumberOfFilmsInSpecificCategory(id);
    }
}
