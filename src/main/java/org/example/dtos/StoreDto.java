package org.example.dtos;

import org.example.dtos.address.AddressDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Store} entity
 */
public class StoreDto implements Serializable {
    private Short id;
    private StaffDto managerStaff;
    private AddressDto address;
    private Date lastUpdate;

    public StoreDto(Short id, StaffDto managerStaff, AddressDto address, Date lastUpdate) {
        this.id = id;
        this.managerStaff = managerStaff;
        this.address = address;
        this.lastUpdate = lastUpdate;
    }

    public StoreDto() {
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public StaffDto getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(StaffDto managerStaff) {
        this.managerStaff = managerStaff;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
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
        StoreDto entity = (StoreDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.managerStaff, entity.managerStaff) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managerStaff, address, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "managerStaff = " + managerStaff + ", " +
                "address = " + address + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}