package org.example.presistance.daos.interfaces;

import org.example.presistance.entities.Address;
import org.example.presistance.entities.Payment;
import org.example.presistance.entities.Rental;
import org.example.presistance.entities.Store;

import java.util.List;

public interface CustomerDao {
    public Store getCustomerHomeStore(int id);

    public List<Payment> getCustomerPayments(int id);

    public Address getCustomerAddress(int id);

    public List<Rental> getCustomerRentals(int id);
}
