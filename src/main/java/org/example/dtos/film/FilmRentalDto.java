package org.example.dtos.film;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Film} entity
 */
public class FilmRentalDto implements Serializable {
    private Integer id;
    private String title;

    public FilmRentalDto() {
    }

    public FilmRentalDto(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public FilmRentalDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FilmRentalDto setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmRentalDto entity = (FilmRentalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ")";
    }
}