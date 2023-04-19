package org.example.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Rental} entity
 */
public class RentalDto implements Serializable {
    private Integer id;
    private Date rentalDate;
    // private CustomerDto customer;
    private Date returnDate;
    private Date lastUpdate;
    // private Set<PaymentDto> payments = new LinkedHashSet<>();

    public RentalDto() {
    }

    public RentalDto(Integer id, Date rentalDate, Date returnDate, Date lastUpdate) {
        this.id = id;
        this.rentalDate = rentalDate;
        //  this.customer = customer;
        this.returnDate = returnDate;
        this.lastUpdate = lastUpdate;
        //this.payments = payments;
    }

    public Integer getId() {
        return id;
    }

    public RentalDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public RentalDto setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
        return this;
    }

    // public CustomerDto getCustomer() {
    //     return customer;
    // }

    // public RentalDto setCustomer(CustomerDto customer) {
    //     this.customer = customer;
    //     return this;
    // }

    public Date getReturnDate() {
        return returnDate;
    }

    public RentalDto setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public RentalDto setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    // public Set<PaymentDto> getPayments() {
    //     return payments;
    // }

    // public RentalDto setPayments(Set<PaymentDto> payments) {
    //     this.payments = payments;
    //     return this;
    // }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalDto entity = (RentalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.rentalDate, entity.rentalDate) &&
                // Objects.equals(this.customer, entity.customer) &&
                Objects.equals(this.returnDate, entity.returnDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
        // Objects.equals(this.payments, entity.payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentalDate, returnDate, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "rentalDate = " + rentalDate + ", " +
                // "customer = " + customer + ", " +
                "returnDate = " + returnDate + ", " +
                "lastUpdate = " + lastUpdate + ")";
        // "payments = " + payments + ")";
    }
}