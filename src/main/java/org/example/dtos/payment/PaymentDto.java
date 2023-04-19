package org.example.dtos.payment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.presistance.entities.Payment} entity
 */
public class PaymentDto implements Serializable {
    private Integer id;
    private Integer customerId;
    private Short staffId;
    private Integer rentalId;
    private BigDecimal amount;
    private Instant paymentDate;
    private Instant lastUpdate;

    public PaymentDto() {
    }

    public PaymentDto(Integer id, Integer customerId, Short staffId, Integer rentalId, BigDecimal amount, Instant paymentDate, Instant lastUpdate) {
        this.id = id;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public PaymentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public PaymentDto setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public Short getStaffId() {
        return staffId;
    }

    public PaymentDto setStaffId(Short staffId) {
        this.staffId = staffId;
        return this;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public PaymentDto setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentDto setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public PaymentDto setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public PaymentDto setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDto entity = (PaymentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.customerId, entity.customerId) &&
                Objects.equals(this.staffId, entity.staffId) &&
                Objects.equals(this.rentalId, entity.rentalId) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.paymentDate, entity.paymentDate) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, staffId, rentalId, amount, paymentDate, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "customerId = " + customerId + ", " +
                "staffId = " + staffId + ", " +
                "rentalId = " + rentalId + ", " +
                "amount = " + amount + ", " +
                "paymentDate = " + paymentDate + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}