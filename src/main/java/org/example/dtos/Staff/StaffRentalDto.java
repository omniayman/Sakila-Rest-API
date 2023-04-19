package org.example.dtos.Staff;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Staff} entity
 */
public class StaffRentalDto implements Serializable {
    private Short id;
    private String firstName;
    private String lastName;

    public StaffRentalDto() {
    }

    public StaffRentalDto(Short id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Short getId() {
        return id;
    }

    public StaffRentalDto setId(Short id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public StaffRentalDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public StaffRentalDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffRentalDto entity = (StaffRentalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ")";
    }
}