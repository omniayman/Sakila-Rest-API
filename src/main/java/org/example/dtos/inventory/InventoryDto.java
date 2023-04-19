package org.example.dtos.inventory;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Inventory} entity
 */
public class InventoryDto implements Serializable {
    private Integer id;
    private Integer filmId;
    private Short storeId;
    private Instant lastUpdate;

    public InventoryDto() {
    }

    public InventoryDto(Integer id, Integer filmId, Short storeId, Instant lastUpdate) {
        this.id = id;
        this.filmId = filmId;
        this.storeId = storeId;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public InventoryDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public InventoryDto setFilmId(Integer filmId) {
        this.filmId = filmId;
        return this;
    }

    public Short getStoreId() {
        return storeId;
    }

    public InventoryDto setStoreId(Short storeId) {
        this.storeId = storeId;
        return this;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public InventoryDto setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryDto entity = (InventoryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.storeId, entity.storeId) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filmId, storeId, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "filmId = " + filmId + ", " +
                "storeId = " + storeId + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}