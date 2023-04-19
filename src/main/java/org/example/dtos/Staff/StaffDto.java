package org.example.dtos.Staff;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Staff} entity
 */
public class StaffDto implements Serializable {
    private Short id;
    private String firstName;
    private String lastName;
    private Integer addressId;

    private byte[] picture;
    private String email;
    private Short storeId;
    private Boolean active = false;
    private String username;
    private String password;
    private Instant lastUpdate;

    public StaffDto() {
    }

    public StaffDto(Short id, String firstName, String lastName, Integer addressId, byte[] picture, String email, Short storeId, Boolean active, String username, String password, Instant lastUpdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;

        this.picture = picture;
        this.email = email;
        this.storeId = storeId;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
    }

    public Short getId() {
        return id;
    }

    public StaffDto setId(Short id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public StaffDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public StaffDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public StaffDto setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }


    public byte[] getPicture() {
        return picture;
    }

    public StaffDto setPicture(byte[] picture) {
        this.picture = picture;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StaffDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Short getStoreId() {
        return storeId;
    }

    public StaffDto setStoreId(Short storeId) {
        this.storeId = storeId;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public StaffDto setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public StaffDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public StaffDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public StaffDto setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffDto entity = (StaffDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.addressId, entity.addressId) &&

                Objects.equals(this.picture, entity.picture) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.storeId, entity.storeId) &&
                Objects.equals(this.active, entity.active) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, addressId, picture, email, storeId, active, username, password, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "addressId = " + addressId + ", " +

                "picture = " + picture + ", " +
                "email = " + email + ", " +
                "storeId = " + storeId + ", " +
                "active = " + active + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}