package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.EntityManagerFactoryProvider;
import org.example.presistance.daos.interfaces.StoreDao;
import org.example.presistance.entities.*;

import java.util.List;

public class StoreDaoImpl extends Crud<Store, Integer> implements StoreDao {
    EntityManager entityManager = EntityManagerFactoryProvider.getInstance().createEntityManager();


    @Override
    public Address getStoreAddress(int id) {
        return (Address) entityManager.createQuery("select c.address from Store c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public List<Customer> getStoreCustomers(int id) {
        return (List<Customer>) entityManager.createQuery("select c.customers from Store c where c.id=?1")
                .setParameter(1, id)
                .getResultList();
    }

    @Override
    public List<Staff> getStoreStaff(int id) {
        return (List<Staff>) entityManager.createQuery("select c.staff from Store c where c.id=?1")
                .setParameter(1, id)
                .getResultList();
    }

    @Override
    public Staff getStoreManager(int id) {
        return (Staff) entityManager.createQuery("select c.managerStaff from Store c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public List<Film> getStoreFilms(int id) {
        return (List<Film>) entityManager.createQuery("select f from Film f join  Inventory i where i.store.id=?1")
                .setParameter(1, id)
                .getResultList();
    }

    @Override
    public List<Rental> getStoreRentals(int id) {
        return (List<Rental>) entityManager.createQuery("select r from Rental r join  Inventory i where   r.inventory.id=i.id  and i.store.id=?1")
                .setParameter(1, id)
                .getResultList();
    }
}
