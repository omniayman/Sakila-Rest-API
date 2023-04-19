package org.example.dtos.store;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Store} entity
 */
public class StoreDto implements Serializable {
    private Short id;
    private Short managerStaffId;
    private String managerStaffFirstName;
    private String managerStaffLastName;
    private Integer addressId;
    private Instant lastUpdate;


    public StoreDto() {
    }

    public StoreDto(Short id, Short managerStaffId, String managerStaffFirstName, String managerStaffLastName, Integer addressId, Instant lastUpdate) {
        this.id = id;
        this.managerStaffId = managerStaffId;
        this.managerStaffFirstName = managerStaffFirstName;
        this.managerStaffLastName = managerStaffLastName;
        this.addressId = addressId;
        this.lastUpdate = lastUpdate;

    }

    public Short getId() {
        return id;
    }

    public StoreDto setId(Short id) {
        this.id = id;
        return this;
    }

    public Short getManagerStaffId() {
        return managerStaffId;
    }

    public StoreDto setManagerStaffId(Short managerStaffId) {
        this.managerStaffId = managerStaffId;
        return this;
    }

    public String getManagerStaffFirstName() {
        return managerStaffFirstName;
    }

    public StoreDto setManagerStaffFirstName(String managerStaffFirstName) {
        this.managerStaffFirstName = managerStaffFirstName;
        return this;
    }

    public String getManagerStaffLastName() {
        return managerStaffLastName;
    }

    public StoreDto setManagerStaffLastName(String managerStaffLastName) {
        this.managerStaffLastName = managerStaffLastName;
        return this;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public StoreDto setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public StoreDto setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreDto entity = (StoreDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.managerStaffId, entity.managerStaffId) &&
                Objects.equals(this.managerStaffFirstName, entity.managerStaffFirstName) &&
                Objects.equals(this.managerStaffLastName, entity.managerStaffLastName) &&
                Objects.equals(this.addressId, entity.addressId) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managerStaffId, managerStaffFirstName, managerStaffLastName, addressId, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "managerStaffId = " + managerStaffId + ", " +
                "managerStaffFirstName = " + managerStaffFirstName + ", " +
                "managerStaffLastName = " + managerStaffLastName + ", " +
                "addressId = " + addressId + ", " +
                "lastUpdate = " + lastUpdate + ") ";

    }
}