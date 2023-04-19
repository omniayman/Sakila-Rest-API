package org.example.presistance.daos.interfaces;

import org.example.presistance.entities.*;

import java.util.List;

public interface StaffDao {
    public Store getStaffStore(int id);

    public List<Rental> getStaffRentals(int id);

    public List<Payment> getStaffPayments(int id);

    public boolean checkStaffManager(int id);

    public long getNumberActiveStaff();

    public List<Staff> getStaffByName(String id);

    public Address getStaffAddress(int id);

}
