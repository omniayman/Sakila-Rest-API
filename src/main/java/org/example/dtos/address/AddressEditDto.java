package org.example.dtos.address;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Address} entity
 */
public class AddressEditDto implements Serializable {
    private Integer id;
    private String address;
    private String address2;
    private String district;
    private CityDto city;
    private String postalCode;
    private String phone;
    private Instant lastUpdate;
    private byte[] location;

    public AddressEditDto() {
    }

    public AddressEditDto(Integer id, String address, String address2, String district, CityDto city, String postalCode, String phone, Instant lastUpdate,
                          byte[] location) {
        this.id = id;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
        this.location = location;
    }

    public byte[] getLocation() {
        return location;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public AddressEditDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AddressEditDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public AddressEditDto setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public AddressEditDto setDistrict(String district) {
        this.district = district;
        return this;
    }

    public CityDto getCity() {
        return city;
    }

    public AddressEditDto setCity(CityDto city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressEditDto setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public AddressEditDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public AddressEditDto setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEditDto entity = (AddressEditDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.address2, entity.address2) &&
                Objects.equals(this.district, entity.district) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.postalCode, entity.postalCode) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, address2, district, city, postalCode, phone, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "address = " + address + ", " +
                "address2 = " + address2 + ", " +
                "district = " + district + ", " +
                "city = " + city + ", " +
                "postalCode = " + postalCode + ", " +
                "phone = " + phone + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}