package org.example.presistance.daos.interfaces;

import org.example.presistance.entities.Customer;
import org.example.presistance.entities.Inventory;
import org.example.presistance.entities.Staff;
import org.example.presistance.exceptionHandler.InvalidDataException;

public interface RentalDao {
    public void returnRent(int id) throws InvalidDataException;

    public Customer getCustomerByRent(int id);

    public Staff getStaffByRent(int id);

    public Inventory getInventoryByRent(int id);
}
