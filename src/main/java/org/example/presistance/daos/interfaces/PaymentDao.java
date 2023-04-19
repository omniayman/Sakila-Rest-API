package org.example.presistance.daos.interfaces;

import org.example.presistance.entities.Customer;
import org.example.presistance.entities.Rental;
import org.example.presistance.entities.Staff;

import java.math.BigDecimal;

public interface PaymentDao {
    public Customer getCustomerByPayment(int id);

    public Rental getRentalByPayment(int id);

    public BigDecimal getMaxPayment();

    public Staff getStaffByPayment(int id);
}
