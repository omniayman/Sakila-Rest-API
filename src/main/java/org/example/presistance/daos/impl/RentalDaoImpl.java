package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.EntityManagerFactoryProvider;
import org.example.presistance.daos.interfaces.RentalDao;
import org.example.presistance.entities.Customer;
import org.example.presistance.entities.Inventory;
import org.example.presistance.entities.Rental;
import org.example.presistance.entities.Staff;
import org.example.presistance.exceptionHandler.InvalidDataException;

import java.time.Instant;
import java.util.Date;

public class RentalDaoImpl extends Crud<Rental, Integer> implements RentalDao {

    EntityManager entityManager = EntityManagerFactoryProvider.getInstance().createEntityManager();

    @Override
    public void add(Rental rental) throws InvalidDataException {
        Integer customerId = (Integer) entityManager.createQuery("select inventory_held_by_customer(?1)")
                .setParameter(1, rental.getInventory().getId())
                .getSingleResult();
        System.out.println(customerId);
        if (customerId == null) {
            entityManager.getTransaction().begin();
            System.out.println("******");

            System.out.println("-----");
            entityManager.persist(rental);
            entityManager.getTransaction().commit();
        } else
            throw new InvalidDataException("this Inventory is rented ");


    }

    @Override
    public void returnRent(int id) throws InvalidDataException {
        Rental rental = entityManager.find(Rental.class, id);
        if (rental == null)
            throw new InvalidDataException("this id does not exist  ");
        if (rental.getReturnDate() == null) {
            entityManager.getTransaction().begin();
            System.out.println(Instant.now());

            rental.setReturnDate(new Date());
            System.out.println(rental.getReturnDate());
            System.out.println(rental);
            entityManager.getTransaction().commit();

        } else {
            throw new InvalidDataException("this is rent is already returned  ");
        }

    }

    @Override
    public Customer getCustomerByRent(int id) {
        return (Customer) entityManager.createQuery("select c.customer from Rental c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public Staff getStaffByRent(int id) {
        return (Staff) entityManager.createQuery("select c.staff from Rental c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    public Inventory getInventoryByRent(int id) {
        return (Inventory) entityManager.createQuery("select c.inventory from Rental c where c.id=?1")
                .setParameter(1, id)
                .getSingleResult();
    }
}
