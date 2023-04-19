package org.example.dtos.rental;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Rental} entity
 */
public class RentalDto implements Serializable {
    private Integer id;
    private Instant rentalDate;
    private Integer inventoryId;
    private Integer customerId;
    private Instant returnDate;
    private Short staffId;
    private Instant lastUpdate;

    public RentalDto() {
    }

    public RentalDto(Integer id, Instant rentalDate, Integer inventoryId, Integer customerId, Instant returnDate, Short staffId, Instant lastUpdate) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.inventoryId = inventoryId;
        this.customerId = customerId;
        this.returnDate = returnDate;
        this.staffId = staffId;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public RentalDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Instant getRentalDate() {
        return rentalDate;
    }

    public RentalDto setRentalDate(Instant rentalDate) {
        this.rentalDate = rentalDate;
        return this;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public RentalDto setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
        return this;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public RentalDto setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public Instant getReturnDate() {
        return returnDate;
    }

    public RentalDto setReturnDate(Instant returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public Short getStaffId() {
        return staffId;
    }

    public RentalDto setStaffId(Short staffId) {
        this.staffId = staffId;
        return this;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public RentalDto setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalDto entity = (RentalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.rentalDate, entity.rentalDate) &&
                Objects.equals(this.inventoryId, entity.inventoryId) &&
                Objects.equals(this.customerId, entity.customerId) &&
                Objects.equals(this.returnDate, entity.returnDate) &&
                Objects.equals(this.staffId, entity.staffId) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "rentalDate = " + rentalDate + ", " +
                "inventoryId = " + inventoryId + ", " +
                "customerId = " + customerId + ", " +
                "returnDate = " + returnDate + ", " +
                "staffId = " + staffId + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}