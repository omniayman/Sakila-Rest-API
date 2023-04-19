package org.example.dtos;

import org.example.dtos.customer.CustomerDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


/**
 * A DTO for the {@link org.example.presistance.entities.Payment} entity
 */
public class PaymentDto implements Serializable {
    private Integer id;

    private CustomerDto customer;
    // private RentalDto rental;
    private BigDecimal amount;
    private Date paymentDate;
    private Date lastUpdate;

    public PaymentDto() {
    }

    // public PaymentDto(Integer id,CustomerDto customer,  BigDecimal amount, Date paymentDate, Date lastUpdate) {
    // //     this.id = id;
    // //     this.customer = customer;
    // //     // this.rental = rental;
    // //     this.amount = amount;
    // //     this.paymentDate = paymentDate;
    // //     this.lastUpdate = lastUpdate;
    // // }

    public Integer getId() {
        return id;
    }

    public PaymentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    // public CustomerDto getCustomer() {
    //     return customer;
    // }

    // public PaymentDto setCustomer(CustomerDto customer) {
    //     this.customer = customer;
    //     return this;
    // }

    // public RentalDto getRental() {
    //     return rental;
    // }

    // public PaymentDto setRental(RentalDto rental) {
    //     this.rental = rental;
    //     return this;
    // }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentDto setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public PaymentDto setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public PaymentDto setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDto entity = (PaymentDto) o;
        return Objects.equals(this.id, entity.id) &&
                // Objects.equals(this.customer, entity.customer) &&
                // Objects.equals(this.rental, entity.rental) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.paymentDate, entity.paymentDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, paymentDate, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                // "customer = " + customer + ", " +
                // "rental = " + rental + ", " +
                "amount = " + amount + ", " +
                "paymentDate = " + paymentDate + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}