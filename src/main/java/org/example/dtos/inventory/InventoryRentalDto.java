package org.example.dtos.inventory;

import org.example.dtos.film.FilmRentalDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Inventory} entity
 */
public class InventoryRentalDto implements Serializable {
    private Integer id;
    private FilmRentalDto film;
    private Short storeId;

    public InventoryRentalDto() {
    }

    public InventoryRentalDto(Integer id, FilmRentalDto film, Short storeId) {
        this.id = id;
        this.film = film;
        this.storeId = storeId;
    }

    public Integer getId() {
        return id;
    }

    public InventoryRentalDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public FilmRentalDto getFilm() {
        return film;
    }

    public InventoryRentalDto setFilm(FilmRentalDto film) {
        this.film = film;
        return this;
    }

    public Short getStoreId() {
        return storeId;
    }

    public InventoryRentalDto setStoreId(Short storeId) {
        this.storeId = storeId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryRentalDto entity = (InventoryRentalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.film, entity.film) &&
                Objects.equals(this.storeId, entity.storeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, film, storeId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "film = " + film + ", " +
                "storeId = " + storeId + ")";
    }
}