package org.example.dtos.store;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Store} entity
 */
public class StoreEditDto implements Serializable {
    private Short id;
    private Short managerStaffId;
    private Integer addressId;
    private Instant lastUpdate = Instant.now();

    public StoreEditDto() {
    }

    public StoreEditDto(Short id, Short managerStaffId, Integer addressId, Instant lastUpdate) {
        this.id = id;
        this.managerStaffId = managerStaffId;
        this.addressId = addressId;
        this.lastUpdate = lastUpdate;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Short getId() {
        return id;
    }

    public StoreEditDto setId(Short id) {
        this.id = id;
        return this;
    }

    public Short getManagerStaffId() {
        return managerStaffId;
    }

    public StoreEditDto setManagerStaffId(Short managerStaffId) {
        this.managerStaffId = managerStaffId;
        return this;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public StoreEditDto setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreEditDto entity = (StoreEditDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.managerStaffId, entity.managerStaffId) &&
                Objects.equals(this.addressId, entity.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managerStaffId, addressId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "managerStaffId = " + managerStaffId + ", " +
                "addressId = " + addressId + ")";
    }
}