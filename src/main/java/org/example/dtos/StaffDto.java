package org.example.dtos;

import org.example.dtos.address.AddressDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Staff} entity
 */
public class StaffDto implements Serializable {
    private Short id;
    private String firstName;
    private String lastName;
    private AddressDto address;
    private byte[] picture;
    private String email;
    private Boolean active;
    private String username;
    private String password;
    private Date lastUpdate;

    public StaffDto(Short id, String firstName, String lastName, AddressDto address, byte[] picture, String email, Boolean active, String username, String password, Date lastUpdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.picture = picture;
        this.email = email;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
    }

    public StaffDto() {
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        StaffDto entity = (StaffDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.picture, entity.picture) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.active, entity.active) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, picture, email, active, username, password, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "address = " + address + ", " +
                "picture = " + picture + ", " +
                "email = " + email + ", " +
                "active = " + active + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}