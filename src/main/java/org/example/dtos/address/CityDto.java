package org.example.dtos.address;

import org.example.presistance.entities.City;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * A DTO for the {@link City} entity
 */
public class CityDto implements Serializable {
    private Integer id;
    private String city;
    private CountryDto country;
    private Date lastUpdate;

    public CityDto() {
    }

    public CityDto(Integer id, String city, CountryDto country, Date lastUpdate) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
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
        CityDto entity = (CityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, country, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "city = " + city + ", " +
                "country = " + country + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}