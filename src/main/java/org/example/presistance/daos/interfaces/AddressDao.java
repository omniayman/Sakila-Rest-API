package org.example.presistance.daos.interfaces;


import org.example.presistance.entities.Customer;
import org.example.presistance.entities.Staff;
import org.example.presistance.entities.Store;

import java.util.List;

public interface AddressDao {
    public List<Customer> getCustomersByAddressId(int id);

    public List<Staff> getStaffByAddressId(int id);

    public List<Store> getStoreByAddressId(int id);
}
