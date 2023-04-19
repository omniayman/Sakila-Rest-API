package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.daos.interfaces.StaffDao;
import org.example.presistance.entities.*;

import java.util.List;

public class StaffDaoImpl extends Crud<Staff, Integer> implements StaffDao {
    EntityManager entityManager;

    public StaffDaoImpl() {
        entityManager = super.getEntityManager();
    }

    @Override
    public Store getStaffStore(int id) {
        return (Store) entityManager.createQuery("select s from Store s join Staff c where c.id=?1").setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public List<Rental> getStaffRentals(int id) {
        return (List<Rental>) entityManager.createQuery("select r from Rental r  where r.staff.id=?1").setParameter(1, id)
                .getResultList();
    }

    @Override
    public List<Payment> getStaffPayments(int id) {
        return (List<Payment>) entityManager.createQuery("select r from Payment r  where r.staff.id=?1").setParameter(1, id)
                .getResultList();
    }

    @Override
    public boolean checkStaffManager(int id) {
        try {
            Store store = (Store) entityManager.createQuery("select r from Store r  where r.managerStaff.id=?1").setParameter(1, id)
                    .getSingleResult();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public long getNumberActiveStaff() {
        long count = (Long) entityManager.createQuery("select count(*) from Staff r  where r.active=true")
                .getSingleResult();
        return count;
    }

    @Override
    public List<Staff> getStaffByName(String name) {
        return (List<Staff>) entityManager.createQuery("from Staff a where a.firstName like ?1  or a.lastName like ?1").
                setParameter(1, "%" + name + "%").getResultList();
    }

    @Override
    public Address getStaffAddress(int id) {
        return (Address) entityManager.createQuery("select c.address from Staff c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();

    }
}
