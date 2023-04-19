package org.example.presistance.daos.interfaces;

import org.example.presistance.entities.*;

import java.util.List;

public interface StoreDao {
    public Address getStoreAddress(int id);

    public List<Customer> getStoreCustomers(int id);

    public List<Staff> getStoreStaff(int id);

    public Staff getStoreManager(int id);

    public List<Film> getStoreFilms(int id);

    public List<Rental> getStoreRentals(int id);
}
