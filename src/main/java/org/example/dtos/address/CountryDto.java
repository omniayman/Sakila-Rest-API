package org.example.dtos.address;

import org.example.presistance.entities.Country;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link Country} entity
 */
public class CountryDto implements Serializable {
    private Integer id;
    private String country;
    private Date lastUpdate;

    public CountryDto() {
    }

    public CountryDto(Integer id, String country, Date lastUpdate) {
        this.id = id;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto entity = (CountryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "country = " + country + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}